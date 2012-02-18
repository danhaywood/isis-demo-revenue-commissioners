package ie.revenue.isisdemo.customers;

import java.util.List;

import org.apache.isis.applib.annotation.Exploration;
import org.apache.isis.applib.annotation.Named;


@Named("Customers")
public interface Customers {

    @Exploration
	public List<Customer> listAll();

	
}
