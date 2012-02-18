package ie.revenue.isisdemo.taxrecord;

import ie.revenue.isisdemo.customers.Customer;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.MemberOrder;

public class TaxCredit extends AbstractDomainObject {

	// {{ Customer (property)
	private Customer customer;

	@MemberOrder(sequence = "1")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}
	// }}

	// {{ Type (property)
	private TaxCreditType type;

	@MemberOrder(sequence = "1")
	public TaxCreditType getType() {
		return type;
	}

	public void setType(final TaxCreditType type) {
		this.type = type;
	}
	// }}

	// {{ TaxYear (property)
	private TaxYear taxYear;

	@Disabled
	@MemberOrder(sequence = "1")
	public TaxYear getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(final TaxYear taxYear) {
		this.taxYear = taxYear;
	}
	// }}

	// {{ Claimed (property)
	private boolean claimed;

	@Disabled
	@MemberOrder(sequence = "4")
	public boolean isClaimed() {
		return claimed;
	}

	public void setClaimed(final boolean claimed) {
		this.claimed = claimed;
	}
	// }}


}
