package ie.revenue.isisdemo.taxrecord;

import ie.revenue.isisdemo.customers.Customer;

import org.apache.isis.applib.AbstractFactoryAndRepository;

public class CustomerTaxRecordsDefault extends AbstractFactoryAndRepository implements CustomerTaxRecords {

    // {{ Id, iconName
    @Override
    public String getId() {
        return "customerTaxRecords";
    }

    public String iconName() {
        return "CustomerTaxRecord";
    }
    // }}

    // {{ taxRecordFor
	@Override
	public CustomerTaxRecord forCustomer(Customer customer) {
		return firstMatch(CustomerTaxRecord.class, Customer.<CustomerTaxRecord>filterTo(customer));
	}
	// }}

}
