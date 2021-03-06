package ie.revenue.isisdemo.custprofile;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
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
		nameUpdated();
	}

	// }}

	// {{ Surname (property)
	private String surname;

	@Named("Last Name")
	@Title(sequence = "1", append = ", ")
	@MemberOrder(sequence = "2")
	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
		nameUpdated();
	}

	// }}

	
	
	// {{ FirstName (property)
	private String firstName;

	@Title(sequence = "2")
	@MemberOrder(sequence = "3")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
		nameUpdated();
	}

	// }}

	// {{ MiddleInitial (property)
	private String propertyName;

	@Title(sequence="3", append=".")
	@Optional
	@MemberOrder(sequence = "4")
	public String getMiddleInitial() {
		return propertyName;
	}

	public void setMiddleInitial(final String propertyName) {
		this.propertyName = propertyName;
	}
	// }}


	
	// {{ Profile (hidden property)
	private CustomerProfile profile;

	@Hidden
	public CustomerProfile getProfile() {
		return profile;
	}

	public void setProfile(final CustomerProfile profile) {
		this.profile = profile;
	}

	// }}

	// {{ helpers
	private void nameUpdated() {
		if (getProfile() == null) {
			return;
		}
		getProfile().nameUpdated(getContainer().titleOf(this));
	}
	// }}

}
