package ie.revenue.isisdemo.corresp;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Immutable;
import org.apache.isis.applib.annotation.MemberOrder;

@Immutable
public class CorrespondenceType extends AbstractDomainObject {

	// {{ Code (property)
	private String code;

	@MemberOrder(sequence = "1")
	public String getCode() {
		return code;
	}

	public void setCode(final String code) {
		this.code = code;
	}
	// }}

	// {{ Name (property)
	private String name;

	@MemberOrder(sequence = "1")
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	// }}

	// {{ Direction (property)
	private CorrespondenceDirection direction;

	@MemberOrder(sequence = "3")
	public CorrespondenceDirection getDirection() {
		return direction;
	}

	public void setDirection(final CorrespondenceDirection direction) {
		this.direction = direction;
	}
	// }}

}
