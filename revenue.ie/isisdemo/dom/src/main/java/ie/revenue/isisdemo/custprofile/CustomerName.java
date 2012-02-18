package ie.revenue.isisdemo.custprofile;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.Title;

public class CustomerName extends AbstractDomainObject {


	// {{ Title (property)
	private CustomerTitle title;

	@Optional
	@MemberOrder(sequence = "1")
	public CustomerTitle getTitle() {
		return title;
	}

	public void setTitle(final CustomerTitle title) {
		this.title = title;
	}
	// }}


	// {{ Surname (property)
	private String surname;

	@Title(sequence="1", append=", ")
	@MemberOrder(sequence = "2")
	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}
	// }}

	// {{ FirstName (property)
	private String firstName;

	@Title(sequence="2")
	@MemberOrder(sequence = "3")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}
	// }}
	
	// {{ MiddleInitial (property)
	private String middleInitial;

	@Optional
	@Title(sequence="3", append=".")
	@MemberOrder(sequence = "4")
	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(final String middleInitial) {
		this.middleInitial = middleInitial;
	}
	// }}




	

	

	
}
