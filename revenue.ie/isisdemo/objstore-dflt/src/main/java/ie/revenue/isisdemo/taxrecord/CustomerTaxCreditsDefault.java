package ie.revenue.isisdemo.taxrecord;

import java.util.List;

import ie.revenue.isisdemo.customers.Customer;

import org.apache.isis.applib.AbstractFactoryAndRepository;


public class CustomerTaxCreditsDefault extends AbstractFactoryAndRepository implements CustomerTaxCredits {

    // {{ Id, iconName
    @Override
    public String getId() {
        return "customerTaxCredits";
    }

    public String iconName() {
        return "CustomerTaxCredit";
    }
    // }}

	@Override
	public List<CustomerTaxCredit> taxCreditsFor(CustomerTaxYear customerTaxYear) {
		return allMatches(CustomerTaxCredit.class, CustomerTaxYear.filterFor(customerTaxYear));
	}


}
