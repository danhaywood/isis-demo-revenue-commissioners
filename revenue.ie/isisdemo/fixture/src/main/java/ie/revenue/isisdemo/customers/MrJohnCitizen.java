package ie.revenue.isisdemo.customers;

import ie.revenue.isisdemo.custprofile.CustomerTitle;
import ie.revenue.isisdemo.custprofile.Language;

import org.apache.isis.applib.value.Date;

public class MrJohnCitizen extends AbstractCustomerFixture {

	@Override
	public void install() {
		Customer customer = createCustomer("3134478H", CustomerTitle.MR, "John", "Citizen", "Smith",
				"282828", new Date(1940, 4, 1), "01 8888888", null, null, Language.ENGLISH,
				0, false);
		
		
		addCustomerTaxCredit(customer, 2010, "Personal");
		addCustomerTaxCredit(customer, 2009, "Personal");
		addCustomerTaxCredit(customer, 2008, "Personal");
	}

}
