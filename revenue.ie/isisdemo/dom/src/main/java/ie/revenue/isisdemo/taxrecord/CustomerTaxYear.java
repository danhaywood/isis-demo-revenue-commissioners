package ie.revenue.isisdemo.taxrecord;

import java.util.ArrayList;
import java.util.List;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.util.TitleBuffer;

public class CustomerTaxYear extends AbstractDomainObject {

	
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


	// {{ TaxCredits (Collection)
	private List<CustomerTaxCredit> taxCredits = new ArrayList<CustomerTaxCredit>();

	@Disabled
	@MemberOrder(sequence = "3")
	public List<CustomerTaxCredit> getTaxCredits() {
		return taxCredits;
	}

	public void setTaxCredits(final List<CustomerTaxCredit> taxCredits) {
		this.taxCredits = taxCredits;
	}
	// }}


	
	// {{ claimTaxCredit (action)
	@MemberOrder(sequence = "1")
	public void claimTaxCredit(final TaxCreditRate taxCreditRate) {
		CustomerTaxCredit ctc = newTransientInstance(CustomerTaxCredit.class);
		ctc.setCustomerTaxYear(this);
		getTaxCredits().add(ctc);
		ctc.setTaxCreditRate(taxCreditRate);
		ctc.setEligibility(TaxCreditEligibility.CLAIMED);
		getContainer().persist(ctc);
	}
	public List<TaxCreditRate> choicesTaxCreditRate() {
		return getContainer().allMatches(TaxCreditRate.class, TaxCreditRate.forTaxYear(this));
	}
	public String validateTaxCreditRate(final TaxCreditRate taxCreditRate) {
		if (taxCreditRate == null)
			return null;
		return choicesTaxCreditRate().contains(taxCreditRate)?null:"Not a valid tax credit rate";
	}
	// }}


}
