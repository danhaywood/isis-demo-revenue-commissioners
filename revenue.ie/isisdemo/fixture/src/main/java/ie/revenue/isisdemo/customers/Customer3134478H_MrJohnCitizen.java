package ie.revenue.isisdemo.customers;

import ie.revenue.isisdemo.custprofile.CustomerTitle;
import ie.revenue.isisdemo.custprofile.Language;

import org.apache.isis.applib.value.Date;

public class Customer3134478H_MrJohnCitizen extends AbstractCustomerFixture {

	@Override
	public void install() {
		createCustomer("3134478H", CustomerTitle.MR, "John", "Citizen", "Smith",
				"282828", new Date(1940, 4, 1), "01 8888888", null, null, Language.ENGLISH,
				0, false);
		
	}

}
