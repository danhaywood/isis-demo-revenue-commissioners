package ie.revenue.isisdemo.taxrecord;

import ie.revenue.isisdemo.taxrecord.TaxCreditRate;
import ie.revenue.isisdemo.taxrecord.TaxCreditType;
import ie.revenue.isisdemo.taxrecord.TaxYear;

import java.util.List;

import org.apache.isis.applib.fixtures.AbstractFixture;

public class TaxCreditTypeAndRatesFixture extends AbstractFixture {


	@Override
	public void install() {
		createTaxCreditType("PAYE", "PAYE Tax Credit", null, 3360);
		createTaxCreditType("Personal", "Personal Tax Credit", null, 1000);
		createTaxCreditType("Age", "Age Tax Credit", "This credit is due when either you or your spouse are aged 65 or over", 650);
		createTaxCreditType("Home", "Home Carers Tax Credit", null, 400);
		createTaxCreditType("Blind", "Blind Persons Tax Credit", null, 500);
		createTaxCreditType("Dependent", "Dependent Relative Tax Credit", null, 600);
		createTaxCreditType("FlatRate", "Flat Rate Tax Credit", null, 400);
		createTaxCreditType("Income", "Income Continuance", null, 800);
		createTaxCreditType("GuideDog", "Guide Dog Allowance", null, 1000);
		createTaxCreditType("Rent", "Rent Tax Credit", null, 700);
		createTaxCreditType("Services", "Services Charge Relief", null, 750);
		createTaxCreditType("Union", "Trade Union Subscriptions", null, 100);
		createTaxCreditType("Child", "Incapacitated Child Tax Credit", null, 600);
		createTaxCreditType("OneParent", "One Parent Family Tax Credit", null, 500);
		createTaxCreditType("Widowed", "Widowed Parent Tax Credit", null, 600);
	}

	private TaxCreditType createTaxCreditType(String code, String name, String helpText, int baseCreditAmount) {
		TaxCreditType creditType = newTransientInstance(TaxCreditType.class);
		creditType.setCode(code);
		creditType.setName(name);
		
		getContainer().persist(creditType);
		int grossReliefDue = baseCreditAmount;
		
		List<TaxYear> taxYears = allInstances(TaxYear.class);
		for (TaxYear taxYear : taxYears) {
			TaxCreditRate taxCreditRate = newTransientInstance(TaxCreditRate.class);
			taxCreditRate.setTaxYear(taxYear);
			taxCreditRate.setType(creditType);
			taxCreditRate.setGrossReliefDue(grossReliefDue);
			grossReliefDue = (int) (grossReliefDue * 1.03); // 3% increase year on year
			
			getContainer().persist(taxCreditRate);
		}
		
		return creditType;
	}

}