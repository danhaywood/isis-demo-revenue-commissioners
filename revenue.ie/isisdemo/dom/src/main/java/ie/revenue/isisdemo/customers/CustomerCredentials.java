package ie.revenue.isisdemo.customers;


import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

public class CustomerCredentials extends AbstractDomainObject {

	public String title() {
		return getCustomer() != null? getCustomer().getPpsn(): "";
	}
	
	// {{ RevenuePinAsDisplayed (derived property)
	@MemberOrder(sequence = "1")
	@Named("Revenue Pin")
	public String getRevenuePinAsDisplayed() {
		return "******";
	}
	// }}

	// {{ RevenuePin (invisible property)
	private String revenuePin;

	@Hidden
	@MemberOrder(sequence = "1")
	public String getRevenuePin() {
		return revenuePin;
	}

	public void setRevenuePin(final String revenuePin) {
		this.revenuePin = revenuePin;
	}
	// }}
	
	// {{ MothersMaidenSurname (property)
	private String mothersMaidenSurname;

	@Disabled
	@MemberOrder(sequence = "1")
	public String getMothersMaidenSurname() {
		return mothersMaidenSurname;
	}

	public void setMothersMaidenSurname(final String mothersMaidenSurname) {
		this.mothersMaidenSurname = mothersMaidenSurname;
	}
	// }}

	// {{ Customer (property)
	private Customer customer;

	@Hidden
	@Disabled
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}
	// }}
	
}
