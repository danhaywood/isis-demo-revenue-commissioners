package ie.revenue.isisdemo.customers;

import org.apache.isis.applib.fixtures.AbstractFixture;

public class CustomersFixture extends AbstractFixture {

	public CustomersFixture() {
		addFixture(new Customer4134484A_MrsJaneCitizen());
		
		addFixture(new Customer3134478H_MrJohnCitizen());
		addFixture(new Customer3134478H_requestsRaise());
		addFixture(new Customer3134478H_requestsApply());
		addFixture(new Customer3134478H_taxCredits());
	}
	
}
