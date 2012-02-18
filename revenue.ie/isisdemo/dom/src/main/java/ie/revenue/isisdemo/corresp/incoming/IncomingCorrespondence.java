package ie.revenue.isisdemo.corresp.incoming;

import ie.revenue.isisdemo.corresp.Correspondence;
import ie.revenue.isisdemo.corresp.CorrespondenceAbstract;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.filter.Filter;

public abstract class IncomingCorrespondence extends CorrespondenceAbstract {

	// {{ Pending (property)
	private boolean pending;

	@MemberOrder(sequence = "8")
	public boolean isPending() {
		return pending;
	}

	public void setPending(final boolean pending) {
		this.pending = pending;
	}
	// }}

	
	// {{ Filters
	public static Filter<Correspondence> filterPendingAs(final boolean pending) {
		return new Filter<Correspondence>(){
			@Override
			public boolean accept(Correspondence t) {
				return t instanceof IncomingCorrespondence && ((IncomingCorrespondence) t).isPending() == pending;
			}};
	}
	// }}


	
}
