package ie.revenue.isisdemo.taxrecord;

import java.util.ArrayList;
import java.util.List;

import ie.revenue.isisdemo.customers.Customer;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.Immutable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.util.TitleBuffer;

@Immutable
public class TaxRecord extends AbstractDomainObject {

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
		List<CustomerTaxYear> taxYears = getTaxYears();
		return taxYears.isEmpty()?null:taxYears.get(0);
	}
	// }}

	
	// {{ TaxYears (Collection)
	private List<CustomerTaxYear> taxYears = new ArrayList<CustomerTaxYear>();

	@Disabled
	@MemberOrder(sequence = "3")
	public List<CustomerTaxYear> getTaxYears() {
		return taxYears;
	}

	public void setTaxYears(final List<CustomerTaxYear> taxYears) {
		this.taxYears = taxYears;
	}
	// }}
	
}
