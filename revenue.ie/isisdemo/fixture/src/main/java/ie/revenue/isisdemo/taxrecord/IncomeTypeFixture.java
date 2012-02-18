package ie.revenue.isisdemo.taxrecord;

import ie.revenue.isisdemo.taxrecord.IncomeType;

import org.apache.isis.applib.fixtures.AbstractFixture;

public class IncomeTypeFixture extends AbstractFixture {


	@Override
	public void install() {
		createIncomeType("Benefit in Kind");
		createIncomeType("Canadian Dividends");
		createIncomeType("Dividend and Distributions");
		createIncomeType("Fees and Commissions");
		createIncomeType("Foreign Pensions");
		createIncomeType("Maintenance Payments Received");
		createIncomeType("Other Foreign Income");
		createIncomeType("Schedule E Non-PAYE Income");
		createIncomeType("UK Dividends");
		createIncomeType("US Dividends");
		createIncomeType("Untaxed Income Arising in the State");
	}

	private IncomeType createIncomeType(String name) {
		IncomeType incomeType = newTransientInstance(IncomeType.class);
		incomeType.setName(name);
		
		getContainer().persist(incomeType);
		
		return incomeType;
	}

}