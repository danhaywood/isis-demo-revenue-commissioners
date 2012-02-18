package ie.revenue.isisdemo.corresp;

import ie.revenue.isisdemo.customers.Customer;


public interface Correspondence {

	Customer getCustomer();
	String getNoticeNumber();
	CorrespondenceType getType();
	boolean isArchived();
	
}
