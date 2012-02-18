package ie.revenue.isisdemo;

import ie.revenue.isisdemo.taxrecord.TaxCreditTypeAndRatesFixture;
import ie.revenue.isisdemo.taxrecord.TaxYearFixture;

import org.apache.isis.applib.fixtures.AbstractFixture;

public class RefDataFixture extends AbstractFixture {

	public RefDataFixture() {
		addFixture(new TaxYearFixture());
		addFixture(new TaxCreditTypeAndRatesFixture());
	}
	
}
