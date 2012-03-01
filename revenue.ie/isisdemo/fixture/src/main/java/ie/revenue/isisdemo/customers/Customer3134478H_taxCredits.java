package ie.revenue.isisdemo.customers;

import ie.revenue.isisdemo.taxrecord.TaxCreditEligibility;

public class Customer3134478H_taxCredits extends AbstractCustomerFixture {

	@Override
	public void install() {
		
		Customer customer = getCustomers().findByPpsn("3134478H");
		
		addCustomerTaxCredit(customer, 2010, "Personal", TaxCreditEligibility.AVAILABLE);
		addCustomerTaxCredit(customer, 2009, "Personal", TaxCreditEligibility.AVAILABLE);
		addCustomerTaxCredit(customer, 2008, "Personal", TaxCreditEligibility.AVAILABLE);
	}

}
