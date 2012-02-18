package ie.revenue.isisdemo.custprofile;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optional;

public class Address extends AbstractDomainObject {


	// {{ Street1 (property)
	private String street1;

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

	@MemberOrder(sequence = "4")
	public String getCounty() {
		return county;
	}

	public void setCounty(final String county) {
		this.county = county;
	}
	// }}


	
}
