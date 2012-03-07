package ie.revenue.isisdemo.taxrecord;

import ie.revenue.isisdemo.customers.Customer;
import ie.revenue.isisdemo.customers.ReferencesCustomer;

import java.util.SortedSet;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.Ignore;
import org.apache.isis.applib.annotation.Immutable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.clock.Clock;
import org.apache.isis.applib.util.TitleBuffer;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;

@Immutable
public class CustomerTaxRecord extends AbstractDomainObject implements ReferencesCustomer {

	// {{ Identification
	public String title() {
		TitleBuffer buf = new TitleBuffer();
		buf.append(getCustomer().getPpsn());
		buf.append(" (tax record)");
		return buf.toString();
	}
	// }}

	// {{ Customer (property)
	private Customer customer;

	@Disabled
	@MemberOrder(sequence = "1")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}
	// }}

	// {{ CurrentTaxYear (derived property)
	@MemberOrder(sequence = "2")
	public CustomerTaxYear getCurrentTaxYear() {
		final int currentYear = Clock.getTimeAsDateTime().getYear();
		for (CustomerTaxYear cty : getTaxYears()) {
			if(cty.getTaxYear().getYear() == currentYear) {
				return cty;
			}
		}
		return null;
	}
	// }}

	// {{ TaxYears (Collection)
	private SortedSet<CustomerTaxYear> taxYears = Sets.newTreeSet(new CustomerTaxYear.MostRecentFirstComparator());

	@Disabled
	@MemberOrder(sequence = "3")
	public SortedSet<CustomerTaxYear> getTaxYears() {
		return taxYears;
	}

	public void setTaxYears(final SortedSet<CustomerTaxYear> taxYears) {
		this.taxYears = taxYears;
	}
	// }}

	// {{ programmatic
	@Ignore
	public CustomerTaxYear taxYearFor(int year) {
		TaxYear taxYear = TaxYear.lookup(year, getContainer());
		return taxYearFor(taxYear);
	}
	@Ignore
	public CustomerTaxYear taxYearFor(TaxYear taxYear) {
		for (CustomerTaxYear cty : getTaxYears()) {
			if(Objects.equal(cty.getTaxYear(), taxYear)) {
				return cty;
			}
		}
		return null;
	}
	// }}
	
}
