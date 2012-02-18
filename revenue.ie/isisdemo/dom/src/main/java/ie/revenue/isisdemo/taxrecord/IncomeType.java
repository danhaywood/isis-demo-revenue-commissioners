package ie.revenue.isisdemo.taxrecord;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.Immutable;
import org.apache.isis.applib.annotation.MemberOrder;

@Immutable
public class IncomeType extends AbstractDomainObject {

	// {{ Name (property)
	private String name;

	@Disabled
	@MemberOrder(sequence = "1")
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	// }}

}
