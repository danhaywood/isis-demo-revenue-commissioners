package ie.revenue.isisdemo.customers;

import ie.revenue.isisdemo.corresp.incoming.CustomerRequest;

import java.util.List;

public class Customer3134478H_requestsApply extends AbstractCustomerFixture {

	@Override
	public void install() {
		Customer customer = getCustomers().findByPpsn("3134478H");

		List<CustomerRequest> pending = getMailbox().correspondenceHistoryFor(customer).getPending();
		for (CustomerRequest request : pending) {
			request.apply();
		}
	}

	
	

}
