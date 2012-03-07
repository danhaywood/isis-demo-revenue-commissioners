package ie.revenue.isisdemo.corresp;

import ie.revenue.isisdemo.corresp.incoming.CustomerRequest;
import ie.revenue.isisdemo.corresp.incoming.IncomingCorrespondence;
import ie.revenue.isisdemo.customers.Customer;

import java.util.List;

import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;


@Hidden
@Named("Mailbox")
public interface Mailbox {

	CorrespondenceHistory correspondenceHistoryFor(Customer customer);

	@Hidden
	List<CustomerRequest> pendingCorrespondence(Customer customer);

	@Hidden
	List<IncomingCorrespondence> currentCorrespondence(Customer customer);

	@Hidden
	List<Correspondence> archivedCorrespondence(Customer customer);

	public int nextNoticeNumber();


}
