package ie.revenue.isisdemo.taxrecord;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Immutable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.filter.Filter;

import com.google.common.base.Objects;

@Immutable
public class TaxCreditRate extends AbstractDomainObject {

	// {{ TaxYear (property)
	private TaxYear year;

	@Title(sequence = "1", append = ":")
	@MemberOrder(sequence = "1")
	public TaxYear getTaxYear() {
		return year;
	}

	public void setTaxYear(final TaxYear year) {
		this.year = year;
	}
	// }}

	
	// {{ Type (property)
	private TaxCreditType type;

	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	public TaxCreditType getType() {
		return type;
	}

	public void setType(final TaxCreditType type) {
		this.type = type;
	}
	// }}

	
	// {{ GrossReliefDue (property)
	private Integer grossReliefDue;

	@MemberOrder(sequence = "3")
	public Integer getGrossReliefDue() {
		return grossReliefDue;
	}

	public void setGrossReliefDue(final Integer grossReliefDue) {
		this.grossReliefDue = grossReliefDue;
	}
	// }}

	
	// {{ programmatic 
	public static Filter<TaxCreditRate> forTaxYear(final CustomerTaxYear customerTaxYear) {
		return new Filter<TaxCreditRate>(){
			@Override
			public boolean accept(TaxCreditRate t) {
				return t.getTaxYear() == customerTaxYear.getTaxCreditRate().getTaxYear();
			}
		};
	}

	public static TaxCreditRate lookup(TaxYear taxYear, TaxCreditType taxCreditType,
			DomainObjectContainer container) {
		return container.firstMatch(TaxCreditRate.class, filterFor(taxYear, taxCreditType));
	}

	private static Filter<TaxCreditRate> filterFor(final TaxYear taxYear, final TaxCreditType taxCreditType) {
		return new Filter<TaxCreditRate>() {
			@Override
			public boolean accept(TaxCreditRate tcr) {
				return Objects.equal(tcr.getTaxYear(), taxYear) && Objects.equal(tcr.getType(), taxCreditType);
			}
		};
	}
	// }}

}
