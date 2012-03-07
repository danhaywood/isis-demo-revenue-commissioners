package ie.revenue.isisdemo.taxrecord;

import ie.revenue.isisdemo.taxrecord.TaxYear;

import org.apache.isis.applib.clock.Clock;
import org.apache.isis.applib.fixtures.AbstractFixture;

public class TaxYearsFixture extends AbstractFixture {


	@Override
	public void install() {
		int currentYear = Clock.getTimeAsDateTime().getYear();
		for(int i = 2007; i<=currentYear; i++) {
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