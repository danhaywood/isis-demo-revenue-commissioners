package ie.revenue.isisdemo.custprofile;

import ie.revenue.isisdemo.customers.Customer;
import ie.revenue.isisdemo.customers.ReferencesCustomer;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.Ignore;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.RegEx;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.TitleBuffer;
import org.apache.isis.applib.value.Date;

public class CustomerProfile extends AbstractDomainObject implements ReferencesCustomer {

	// {{ Identification
	public String title() {
		TitleBuffer buf = new TitleBuffer();
		buf.append(getCustomer().getPpsn());
		buf.append(" (customer profile)");
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

	// {{ Name (property)
	private CustomerName name;

	@Disabled
	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	public CustomerName getName() {
		return name;
	}

	public void setName(final CustomerName name) {
		this.name = name;
	}
	// }}

	// {{ DateOfBirth (property)
	private Date dateOfBirth;

	@MemberOrder(sequence = "3")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(final Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	// }}

	// {{ Language (property)
	private Language language;

	@MemberOrder(sequence = "4")
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(final Language language) {
		this.language = language;
	}
	// }}

	// {{ Address (property)
	private Address address;

	@MemberOrder(sequence = "3")
	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}
	// }}

	// {{ PhoneNumber (property)
	private String phoneNumber;

	@Optional
	@RegEx(validation = "\\d+ \\d+")
	@MemberOrder(sequence = "5")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	// }}
	
	// {{ MobileNumber (property)
	private String mobileNumber;

	@Optional
	@RegEx(validation = "\\d+ \\d+")
	@MemberOrder(sequence = "5.5")
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(final String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	// }}

	// {{ EmailAddress (property)
	private String emailAddress;

	@Optional
	@MemberOrder(sequence = "6")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}
	// }}
	
	// {{ NumberDependentChildren (property)
	private Integer numberDependentChildren;

	@Optional
	@MemberOrder(sequence = "7")
	public Integer getNumberDependentChildren() {
		return numberDependentChildren;
	}

	public void setNumberDependentChildren(final Integer numberDependentChildren) {
		this.numberDependentChildren = numberDependentChildren;
	}
	// }}
	
	// {{ GoPaperFree (property)
	private boolean goPaperFree;

	@MemberOrder(sequence = "8")
	public boolean getGoPaperFree() {
		return goPaperFree;
	}

	public void setGoPaperFree(final boolean goPaperFree) {
		this.goPaperFree = goPaperFree;
	}
	// }}

	// {{ programmatic helpers
	@Ignore
	void nameUpdated(String newName) {
		getCustomer().setName(newName);
	}
	// }}
	
}
