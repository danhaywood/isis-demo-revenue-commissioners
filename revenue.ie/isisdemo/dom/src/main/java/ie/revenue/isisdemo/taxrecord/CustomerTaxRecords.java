package ie.revenue.isisdemo.taxrecord;

import ie.revenue.isisdemo.customers.Customer;

import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;


@Hidden
@Named("Tax Records")
public interface CustomerTaxRecords {

	CustomerTaxRecord forCustomer(Customer customer);
}
