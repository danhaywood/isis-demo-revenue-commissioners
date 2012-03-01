package ie.revenue.isisdemo.custprofile;

import ie.revenue.isisdemo.customers.Customer;

import org.apache.isis.applib.AbstractFactoryAndRepository;

public class CustomerProfilesDefault extends AbstractFactoryAndRepository implements CustomerProfiles {

    // {{ Id, iconName
    @Override
    public String getId() {
        return "customerProfiles";
    }

    public String iconName() {
        return "CustomerProfile";
    }
    // }}

    // {{ profileFor
	@Override
	public CustomerProfile profileFor(Customer customer) {
		return firstMatch(CustomerProfile.class, Customer.<CustomerProfile>filterTo(customer));
	}
	// }}

}
