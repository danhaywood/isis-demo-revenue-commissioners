package ie.revenue.isisdemo.corresp;

import ie.revenue.isisdemo.corresp.incoming.IncomingCorrespondence;
import ie.revenue.isisdemo.customers.Customer;

import java.util.List;

import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;


@Hidden
@Named("Mailbox")
public interface Mailbox {

	List<IncomingCorrespondence> pending(Customer customer);

	List<Correspondence> recentCorrespondence(Customer customer);
	
}
