package ie.revenue.isisdemo.taxrecord;

import ie.revenue.isisdemo.corresp.CorrespondenceType;
import ie.revenue.isisdemo.corresp.incoming.CustomerRequest;
import ie.revenue.isisdemo.customers.Customer;
import ie.revenue.isisdemo.util.PropertiesIgnoringNullValue;

import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.Ignore;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.filter.Filter;
import org.apache.isis.applib.util.TitleBuffer;

import com.google.common.base.Objects;

public class CustomerTaxYear extends AbstractDomainObject implements Comparable<CustomerTaxYear>{

	// {{ Identification
	public String title() {
		final TitleBuffer buf = new TitleBuffer();
		buf.append(getTaxRecord().getCustomer().getPpsn());
		buf.append(": ");
		buf.append(getContainer().titleOf(getTaxYear()));
		return buf.toString();
	}
	// }}

	// {{ TaxRecord (property)
	private CustomerTaxRecord taxRecord;

	@Disabled
	@MemberOrder(sequence = "1")
	public CustomerTaxRecord getTaxRecord() {
		return taxRecord;
	}

	public void setTaxRecord(final CustomerTaxRecord taxRecord) {
		this.taxRecord = taxRecord;
	}
	// }}

	// {{ TaxYear (property)
	private TaxYear taxYear;

	@Disabled
	@MemberOrder(sequence = "2")
	public TaxYear getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(final TaxYear taxYear) {
		this.taxYear = taxYear;
	}
	// }}

	// {{ requestClaimForTaxCredit (action)
	@MemberOrder(sequence = "1")
	public void requestClaimForTaxCredit(
			final TaxCreditRate taxCreditRate) {
		CorrespondenceType correspondenceType = CorrespondenceType.lookup("CLM", getContainer());
		Integer year = this.getTaxYear().getYear();
		String taxCreditCode = taxCreditRate.getType().getCode();
		Customer customer = getTaxRecord().getCustomer();
		correspondenceType.createRequest(customer, ""+year, taxCreditCode);
	}
	public List<TaxCreditRate> choices0RequestClaimForTaxCredit() {
		return getContainer().allMatches(TaxCreditRate.class, TaxCreditRate.forTaxYear(this));
	}
	public String validateRequestClaimForTaxCredit(final TaxCreditRate taxCreditRate) {
		if (taxCreditRate == null)
			return null;
		return choices0RequestClaimForTaxCredit().contains(taxCreditRate)?null:"Not a valid tax credit rate";
	}
	
	public static class ClaimTaxCreditCommand implements CustomerRequest.Command {
		public Properties propertiesFor(Customer customer, String... args) {
			Properties properties = new PropertiesIgnoringNullValue();
			properties.put("taxYear", args[0]);
			properties.put("taxCreditCode", args[1]);
			return properties;
		}

		@Override
		public void apply(Customer customer, Properties properties) {
			Integer year = Integer.parseInt(properties.getProperty("taxYear"));
			String taxCreditCode = properties.getProperty("taxCreditCode");
			
			CustomerTaxRecord taxRecord = taxRecords.forCustomer(customer);
			TaxYear taxYear = TaxYear.lookup(year, container);
			CustomerTaxYear customerTaxYear = taxRecord.taxYearFor(year);
			
			TaxCreditType taxCreditType = TaxCreditType.lookup(taxCreditCode, container);
			TaxCreditRate taxCreditRate = TaxCreditRate.lookup(taxYear, taxCreditType, container);
			customerTaxYear.claimTaxCredit(taxCreditRate);
		}

		// {{ injected: DomainObjectContainer
		private DomainObjectContainer container;

		public void setDomainObjectContainer(final DomainObjectContainer container) {
			this.container = container;
		}
		// }}


		// {{ injected: CustomerTaxRecords
		private CustomerTaxRecords taxRecords;

		public void setCustomerTaxRecords(final CustomerTaxRecords taxRecords) {
			this.taxRecords = taxRecords;
		}
		// }}
	}
	
	@Ignore
	private CustomerTaxYear claimTaxCredit(final TaxCreditRate taxCreditRate) {
		CustomerTaxCredit ctc = newTransientInstance(CustomerTaxCredit.class);
		ctc.setCustomerTaxYear(this);
		ctc.setTaxCreditRate(taxCreditRate);
		ctc.setEligibility(TaxCreditEligibility.CLAIMED);
		getContainer().persist(ctc);
		
		return this;
	}

	// }}


	// {{ filters
	public static Filter<CustomerTaxCredit> filterFor(final CustomerTaxYear customerTaxYear) {
		return new Filter<CustomerTaxCredit>() {
			@Override
			public boolean accept(CustomerTaxCredit t) {
				return Objects.equal(t.getCustomerTaxYear(), customerTaxYear);
			}
		};
	}
	// }}

	// {{ Comparable (impl), MostRecentFirstComparator
	@Ignore
	@Override
	public int compareTo(CustomerTaxYear o) {
		return getTaxYear().compareTo(o.getTaxYear());
	}

	public static class MostRecentFirstComparator implements Comparator<CustomerTaxYear> {
		@Override
		public int compare(CustomerTaxYear cty1, CustomerTaxYear cty2) {
			return - (cty1.getTaxYear().compareTo(cty2.getTaxYear()));
		}
	}
	// 


}
