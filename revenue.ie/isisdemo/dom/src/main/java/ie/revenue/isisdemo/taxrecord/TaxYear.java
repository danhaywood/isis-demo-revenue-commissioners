package ie.revenue.isisdemo.taxrecord;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Immutable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.filter.Filter;

import com.google.common.base.Objects;

@Immutable
public class TaxYear extends AbstractDomainObject implements Comparable<TaxYear> {

	// {{ Year (property)
	private Integer year;

	@Title(sequence = "1")
	@MemberOrder(sequence = "1")
	public Integer getYear() {
		return year;
	}

	public void setYear(final Integer year) {
		this.year = year;
	}
	// }}
	
	// {{ programmatic
	public static TaxYear lookup(int year, DomainObjectContainer container) {
		return container.firstMatch(TaxYear.class, filterYear(year));
	}

	public static Filter<TaxYear> filterYear(final int year) {
		return new Filter<TaxYear>() {

			@Override
			public boolean accept(TaxYear t) {
				return Objects.equal(t.getYear(), year);
			}
		};
	}
	// }}

	// {{ comparable
	@Override
	public int compareTo(TaxYear taxYear) {
		return getYear().compareTo(taxYear.getYear());
	}
	// }}


}
