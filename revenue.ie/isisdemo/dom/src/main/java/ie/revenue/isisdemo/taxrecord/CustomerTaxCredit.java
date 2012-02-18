package ie.revenue.isisdemo.taxrecord;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.util.TitleBuffer;

public class CustomerTaxCredit extends AbstractDomainObject {


	// {{ Identification
	public String title() {
		final TitleBuffer buf = new TitleBuffer();
		buf.append(getContainer().titleOf(getCustomerTaxYear()));
		buf.append(getContainer().titleOf(getTaxCreditRate().getType()));
		return buf.toString();
	}
	// }}

	// {{ CustomerTaxYear (property)
	private CustomerTaxYear customerTaxYear;

	@Disabled
	@MemberOrder(sequence = "1")
	public CustomerTaxYear getCustomerTaxYear() {
		return customerTaxYear;
	}

	public void setCustomerTaxYear(final CustomerTaxYear customerTaxYear) {
		this.customerTaxYear = customerTaxYear;
	}
	// }}

	// {{ TaxCreditRate (property)
	private TaxCreditRate taxCreditRate;

	@MemberOrder(sequence = "2")
	public TaxCreditRate getTaxCreditRate() {
		return taxCreditRate;
	}

	public void setTaxCreditRate(final TaxCreditRate taxCreditRate) {
		this.taxCreditRate = taxCreditRate;
	}
	// }}

	// {{ Eligibility (property)
	private TaxCreditEligibility eligibility;

	@MemberOrder(sequence = "3")
	public TaxCreditEligibility getEligibility() {
		return eligibility;
	}

	public void setEligibility(final TaxCreditEligibility eligibility) {
		this.eligibility = eligibility;
	}
	// }}



}
