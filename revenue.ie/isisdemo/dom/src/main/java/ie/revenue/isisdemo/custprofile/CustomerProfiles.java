package ie.revenue.isisdemo.custprofile;

import ie.revenue.isisdemo.customers.Customer;

import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;


@Hidden
@Named("Profiles")
public interface CustomerProfiles {

	CustomerProfile profileFor(Customer customer);

}
