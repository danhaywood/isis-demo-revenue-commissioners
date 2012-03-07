package ie.revenue.isisdemo.corresp;

import ie.revenue.isisdemo.customers.Customer;

import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.filter.Filter;


public class CorrespondenceAbstract implements Correspondence {

	// {{ CorrespondenceHistory (property)
	private CorrespondenceHistory correspondenceHistory;

	@Disabled
	@MemberOrder(sequence = "1")
	public CorrespondenceHistory getCorrespondenceHistory() {
		return correspondenceHistory;
	}

	public void setCorrespondenceHistory(final CorrespondenceHistory correspondenceHistory) {
		this.correspondenceHistory = correspondenceHistory;
	}
	// }}

	// {{ NoticeNumber (property)
	private int noticeNumber;

	@Override
	@Title
	@Disabled
	@MemberOrder(sequence = "1")
	public int getNoticeNumber() {
		return noticeNumber;
	}

	public void setNoticeNumber(final int noticeNumber) {
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

	@Disabled
	@MemberOrder(sequence = "3")
	public boolean isArchived() {
		return archived;
	}

	public void setArchived(final boolean archived) {
		this.archived = archived;
	}
	// }}

	// {{ filters (programmatic)
	public static <T extends Correspondence> Filter<T> filterArchivedAs(final boolean archived) {
		return new Filter<T>(){
			@Override
			public boolean accept(T t) {
				return t.isArchived() == archived;
			}};
	}

	public static <T extends Correspondence> Filter<T> filterCorrespondenceFor(
			final Customer customer) {
		return new Filter<T>(){
			
			@Override
			public boolean accept(T t) {
				return t.getCorrespondenceHistory().getCustomer() == customer;
			}};
	}
	// }}



}
