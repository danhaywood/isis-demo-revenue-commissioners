package ie.revenue.isisdemo.custprofile;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.annotation.Title;

public class Address extends AbstractDomainObject {


	// {{ Street1 (property)
	private String street1;

	@Disabled
	@Title(sequence="1")
	@MemberOrder(sequence = "1")
	public String getStreet1() {
		return street1;
	}

	public void setStreet1(final String street1) {
		this.street1 = street1;
	}
	// }}


	// {{ Street2 (property)
	private String street2;

	@Disabled
	@Title(sequence="2", prepend=", ")
	@Optional
	@MemberOrder(sequence = "2")
	public String getStreet2() {
		return street2;
	}

	public void setStreet2(final String street2) {
		this.street2 = street2;
	}
	// }}


	// {{ Town (property)
	private String town;

	@Disabled
	@Title(sequence="3", prepend=", ")
	@MemberOrder(sequence = "3")
	public String getTown() {
		return town;
	}

	public void setTown(final String town) {
		this.town = town;
	}
	// }}


	// {{ County (property)
	private String county;

	@Disabled
	@Title(sequence="4", prepend=", ")
	@MemberOrder(sequence = "4")
	public String getCounty() {
		return county;
	}

	public void setCounty(final String county) {
		this.county = county;
	}
	// }}

	
	// {{ TestCounty (property)
	private County testCounty;

	@Optional
	@MemberOrder(sequence = "5")
	public County getTestCounty() {
		return testCounty;
	}

	public void setTestCounty(final County county) {
		this.testCounty = county;
	}
	// }}



	
}
