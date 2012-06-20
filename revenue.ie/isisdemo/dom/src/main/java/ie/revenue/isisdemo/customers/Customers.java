package ie.revenue.isisdemo.customers;

import java.util.List;

import org.apache.isis.applib.annotation.Exploration;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.QueryOnly;


@Named("Customers")
public interface Customers {

	@QueryOnly
	public Customer findByPpsn(@Named("PPSN") String ppsn);

	@QueryOnly
    @Exploration
	public List<Customer> listAll();
	
}
