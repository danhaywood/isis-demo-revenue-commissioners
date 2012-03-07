package ie.revenue.isisdemo.corresp.incoming;

import ie.revenue.isisdemo.corresp.CorrespondenceAbstract;

import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.filter.Filter;

public abstract class IncomingCorrespondence extends CorrespondenceAbstract {

	// {{ Pending (property)
	private boolean pending;

	@Disabled
	@MemberOrder(sequence = "8")
	public boolean isPending() {
		return pending;
	}

	public void setPending(final boolean pending) {
		this.pending = pending;
	}
	// }}
	
	// {{ Filters
	public static <T extends IncomingCorrespondence> Filter<T> filterPendingAs(final boolean pending) {
		return new Filter<T>(){
			@Override
			public boolean accept(IncomingCorrespondence t) {
				return t.isPending() == pending;
			}};
	}
	// }}


	
}
