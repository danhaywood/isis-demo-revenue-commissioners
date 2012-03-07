package ie.revenue.isisdemo.customers;

import ie.revenue.isisdemo.custprofile.CustomerProfile;
import ie.revenue.isisdemo.custprofile.CustomerProfileRequests;

public class Customer3134478H_requestsRaise extends AbstractCustomerFixture {

	@Override
	public void install() {
		
		Customer customer = getCustomers().findByPpsn("3134478H");

		CustomerProfile customerProfile = getCustomerProfiles().profileFor(customer);
		
		customerProfileRequests.updateEmailAddress(customerProfile, "john@citizen.ie");
		customerProfileRequests.updateAddress(customerProfile, "14 Acorn Grove", null, "Longwood", "Co. Meath");
	}



	// {{ injected: CustomerProfileRequests
	private CustomerProfileRequests customerProfileRequests;

	public void setCustomerProfileRequests(final CustomerProfileRequests customerProfileRequests) {
		this.customerProfileRequests = customerProfileRequests;
	}
	// }}


}
