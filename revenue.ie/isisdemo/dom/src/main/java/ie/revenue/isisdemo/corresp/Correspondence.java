package ie.revenue.isisdemo.corresp;

public interface Correspondence {

	CorrespondenceHistory getCorrespondenceHistory();
	
	int getNoticeNumber();
	
	CorrespondenceType getType();
	
	boolean isArchived();
	
}
