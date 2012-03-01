package ie.revenue.isisdemo.customers;

import ie.revenue.isisdemo.custprofile.CustomerTitle;
import ie.revenue.isisdemo.custprofile.Language;

import org.apache.isis.applib.value.Date;

public class Customer4134484A_MrsJaneCitizen extends AbstractCustomerFixture {

	@Override
	public void install() {
		createCustomer("4134484A", CustomerTitle.MRS, "Jane", "Citizen", "Morris",
				"191919", new Date(1940, 1, 1), "01 8888888", null, "jas.c@revenue.ie", Language.ENGLISH,
				0, false);
	}

}
