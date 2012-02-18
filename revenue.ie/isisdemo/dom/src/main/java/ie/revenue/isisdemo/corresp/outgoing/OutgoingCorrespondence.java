package ie.revenue.isisdemo.corresp.outgoing;

import ie.revenue.isisdemo.corresp.CorrespondenceAbstract;

import org.apache.isis.applib.annotation.MemberOrder;

public class OutgoingCorrespondence extends CorrespondenceAbstract {

	
	// {{ Read (property)
	private boolean read;

	@MemberOrder(sequence = "7")
	public boolean isRead() {
		return read;
	}

	public void setRead(final boolean read) {
		this.read = read;
	}
	// }}

	
}
