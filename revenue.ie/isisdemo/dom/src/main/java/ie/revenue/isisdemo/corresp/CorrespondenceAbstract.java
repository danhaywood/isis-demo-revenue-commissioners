package ie.revenue.isisdemo.corresp;

import ie.revenue.isisdemo.customers.Customer;

import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.filter.Filter;


public class CorrespondenceAbstract implements Correspondence {

	// {{ Customer (property)
	private Customer customer;

	@Disabled
	@MemberOrder(sequence = "1")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}
	// }}

	// {{ NoticeNumber (property)
	private String noticeNumber;

	@Override
	@Disabled
	@MemberOrder(sequence = "1")
	public String getNoticeNumber() {
		return noticeNumber;
	}

	public void setNoticeNumber(final String noticeNumber) {
		this.noticeNumber = noticeNumber;
	}
	// }}

	// {{ Type (property)
	private CorrespondenceType type;

	@Disabled
	@MemberOrder(sequence = "2")
	public CorrespondenceType getType() {
		return type;
	}

	public void setType(final CorrespondenceType type) {
		this.type = type;
	}
	// }}

	// {{ Archived (property)
	private boolean archived;

	@MemberOrder(sequence = "3")
	public boolean isArchived() {
		return archived;
	}

	public void setArchived(final boolean archived) {
		this.archived = archived;
	}
	// }}

	// {{ filters (programmatic)
	public static Filter<Correspondence> filterArchivedAs(final boolean archived) {
		return new Filter<Correspondence>(){
			@Override
			public boolean accept(Correspondence t) {
				return t.isArchived() == archived;
			}};
	}

	public static Filter<Correspondence> filterCorrespondenceFor(
			final Customer customer) {
		return new Filter<Correspondence>(){
			
			@Override
			public boolean accept(Correspondence t) {
				return t.getCustomer() == customer;
			}};
	}
	// }}


}
