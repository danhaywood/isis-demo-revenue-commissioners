package ie.revenue.isisdemo.taxrecord;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.Immutable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.filter.Filter;

import com.google.common.base.Objects;

@Immutable
public class TaxCreditType extends AbstractDomainObject {

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

	@Title
	@Disabled
	@MemberOrder(sequence = "1")
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	// }}

	// {{ HelpText (property)
	private String helpText;

	@MemberOrder(sequence = "2")
	public String getHelpText() {
		return helpText;
	}

	public void setHelpText(final String helpText) {
		this.helpText = helpText;
	}
	// }}
	
	// {{ programmatic
	public static TaxCreditType lookup(final String code, DomainObjectContainer container) {
		return container.firstMatch(TaxCreditType.class, filterFor(code));
	}

	public static Filter<TaxCreditType> filterFor(final String code) {
		return new Filter<TaxCreditType>(){

			@Override
			public boolean accept(TaxCreditType t) {
				return Objects.equal(t.getCode(), code);
			}};
	}
	// }}
	
}
