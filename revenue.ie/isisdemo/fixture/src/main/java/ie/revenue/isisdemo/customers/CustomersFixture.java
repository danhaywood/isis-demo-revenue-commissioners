package ie.revenue.isisdemo.customers;

import org.apache.isis.applib.fixtures.AbstractFixture;

public class CustomersFixture extends AbstractFixture {

	public CustomersFixture() {
		addFixture(new MrsJaneCitizen());
		addFixture(new MrJohnCitizen());
	}
	
}
