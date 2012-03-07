package ie.revenue.isisdemo.corresp;

import ie.revenue.isisdemo.corresp.incoming.IncomingCorrespondence;
import ie.revenue.isisdemo.corresp.outgoing.OutgoingCorrespondence;


public enum CorrespondenceDirection {
	/**
	 * {@link Correspondence} whose {@link Correspondence#getType() type} is incoming
	 * will be of subtype {@link IncomingCorrespondence}.
	 */
	Incoming,
	/**
	 * {@link Correspondence} whose {@link Correspondence#getType() type} is incoming
	 * will be of subtype {@link OutgoingCorrespondence}.
	 */
	Outgoing 
}
