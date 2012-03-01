package ie.revenue.isisdemo.corresp;

import ie.revenue.isisdemo.corresp.incoming.IncomingCorrespondence;
import ie.revenue.isisdemo.customers.Customer;
import ie.revenue.isisdemo.customers.ReferencesCustomer;

import java.util.List;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.MemberOrder;
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

	// {{ RecentCorrespondence (Collection)
	@MemberOrder(sequence = "2")
	public List<Correspondence> getRecentCorrespondence() {
		return mailbox.recentCorrespondence(getCustomer());
	}
	// }}

	// {{ Pending (Collection)
	@MemberOrder(sequence = "3")
	public List<IncomingCorrespondence> getPending() {
		return mailbox.pendingCorrespondence(getCustomer());
	}
	// }}

	// {{ injected: Mailbox
	private Mailbox mailbox;

	public void setMailbox(final Mailbox mailbox) {
		this.mailbox = mailbox;
	}
	// }}

	
	
}
