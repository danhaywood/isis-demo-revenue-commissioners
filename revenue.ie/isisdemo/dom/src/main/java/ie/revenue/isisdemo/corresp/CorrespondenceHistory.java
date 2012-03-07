package ie.revenue.isisdemo.corresp;

import ie.revenue.isisdemo.corresp.incoming.CustomerRequest;
import ie.revenue.isisdemo.corresp.incoming.IncomingCorrespondence;
import ie.revenue.isisdemo.customers.Customer;
import ie.revenue.isisdemo.customers.ReferencesCustomer;

import java.util.List;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NotPersisted;
import org.apache.isis.applib.util.TitleBuffer;

public class CorrespondenceHistory extends AbstractDomainObject implements ReferencesCustomer {

	// {{ Identification
	public String title() {
		TitleBuffer buf = new TitleBuffer();
		buf.append(getCustomer().getPpsn());
		buf.append(" (correspondence history)");
		return buf.toString();
	}
	// }}

	// {{ Customer (property)
	private Customer customer;

	@MemberOrder(sequence = "1")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}
	// }}

	// {{ Pending (derived Collection)
	@NotPersisted
	@Disabled
	@MemberOrder(sequence = "2")
	public List<CustomerRequest> getPending() {
		return mailbox.pendingCorrespondence(getCustomer());
	}
	// }}

	// {{ CurrentCorrespondence (derived collection)
	@NotPersisted
	@Disabled
	@MemberOrder(sequence = "3")
	public List<IncomingCorrespondence> getCurrentCorrespondence() {
		return mailbox.currentCorrespondence(getCustomer());
	}
	// }}

	// {{ ArchivedCorrespondence (derived collection)
	@NotPersisted
	@Disabled
	@MemberOrder(sequence = "4")
	public List<Correspondence> getArchivedCorrespondence() {
		return mailbox.archivedCorrespondence(getCustomer());
	}
	// }}

	// {{ injected: Mailbox
	private Mailbox mailbox;

	public void setMailbox(final Mailbox mailbox) {
		this.mailbox = mailbox;
	}
	// }}

	
	
}
