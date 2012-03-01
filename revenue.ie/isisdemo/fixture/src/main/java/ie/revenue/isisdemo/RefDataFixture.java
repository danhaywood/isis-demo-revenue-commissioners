package ie.revenue.isisdemo;

import ie.revenue.isisdemo.taxrecord.TaxCreditTypeAndRatesFixture;
import ie.revenue.isisdemo.taxrecord.TaxYearsFixture;

import org.apache.isis.applib.fixtures.AbstractFixture;

public class RefDataFixture extends AbstractFixture {

	public RefDataFixture() {
		addFixture(new TaxYearsFixture());
		addFixture(new TaxCreditTypeAndRatesFixture());
	}
	
}
