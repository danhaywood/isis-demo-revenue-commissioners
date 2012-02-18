package ie.revenue.isisdemo.customers;

import ie.revenue.isisdemo.corresp.Correspondence;
import ie.revenue.isisdemo.corresp.CorrespondenceHistory;
import ie.revenue.isisdemo.corresp.incoming.IncomingCorrespondence;
import ie.revenue.isisdemo.custprofile.CustomerName;
import ie.revenue.isisdemo.custprofile.CustomerProfile;
import ie.revenue.isisdemo.taxrecord.TaxRecord;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.Ignore;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.filter.Filter;

public class Customer extends AbstractDomainObject {

	// {{ Ppsn (property)
	private String ppsn;

	@Disabled
	@Title(sequence = "1", append=": ")
	@MemberOrder(sequence = "1")
	public String getPpsn() {
		return ppsn;
	}

	public void setPpsn(final String ppsn) {
		this.ppsn = ppsn;
	}
	// }}
	
	// {{ Name (derived property)

	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	public CustomerName getName() {
		return getProfile().getName();
	}
	// }}

	// {{ Credentials (property)
	private CustomerCredentials credentials;

	@Disabled
	@MemberOrder(sequence = "3")
	public CustomerCredentials getCredentials() {
		return credentials;
	}

	public void setCredentials(final CustomerCredentials credentials) {
		this.credentials = credentials;
	}
	// }}

	// {{ Profile (property)
	private CustomerProfile profile;

	@Disabled
	@MemberOrder(sequence = "4")
	public CustomerProfile getProfile() {
		return profile;
	}

	public void setProfile(final CustomerProfile profile) {
		this.profile = profile;
	}
	// }}

	// {{ TaxRecord (property)
	private TaxRecord taxRecord;

	@Disabled
	@MemberOrder(sequence = "5")
	public TaxRecord getTaxRecord() {
		return taxRecord;
	}

	public void setTaxRecord(final TaxRecord taxRecord) {
		this.taxRecord = taxRecord;
	}
	// }}

	// {{ CorrespondenceHistory (property)
	private CorrespondenceHistory correspondenceHistory;

	@Disabled
	@MemberOrder(sequence = "6")
	public CorrespondenceHistory getCorrespondenceHistory() {
		return correspondenceHistory;
	}

	public void setCorrespondenceHistory(final CorrespondenceHistory requestsHistory) {
		this.correspondenceHistory = requestsHistory;
	}
	// }}

	// {{ filters (programmatic)
	@Ignore
	public Filter<Correspondence> filterCorrespondence() {
		return new Filter<Correspondence>(){
	
			@Override
			public boolean accept(Correspondence t) {
				return t.getCustomer() == Customer.this;
			}};
	}
	// }}
	
}
