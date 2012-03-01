package ie.revenue.isisdemo.taxrecord;

import ie.revenue.isisdemo.taxrecord.TaxYear;

import org.apache.isis.applib.fixtures.AbstractFixture;

public class TaxYearsFixture extends AbstractFixture {


	@Override
	public void install() {
		for(int i = 1979; i<2015; i++) {
			createTaxYear(i);
		}
	}

	private TaxYear createTaxYear(int year) {
		TaxYear taxYear = newTransientInstance(TaxYear.class);
		taxYear.setYear(year);
		
		getContainer().persist(taxYear);
		
		return taxYear;
	}

}