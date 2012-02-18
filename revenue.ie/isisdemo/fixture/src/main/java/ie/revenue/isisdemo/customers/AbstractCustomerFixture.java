package ie.revenue.isisdemo.customers;

import java.util.List;

import ie.revenue.isisdemo.corresp.CorrespondenceHistory;
import ie.revenue.isisdemo.custprofile.CustomerName;
import ie.revenue.isisdemo.custprofile.CustomerProfile;
import ie.revenue.isisdemo.custprofile.CustomerTitle;
import ie.revenue.isisdemo.custprofile.Language;
import ie.revenue.isisdemo.taxrecord.CustomerTaxYear;
import ie.revenue.isisdemo.taxrecord.TaxCreditRate;
import ie.revenue.isisdemo.taxrecord.TaxCreditType;
import ie.revenue.isisdemo.taxrecord.TaxRecord;
import ie.revenue.isisdemo.taxrecord.TaxYear;

import org.apache.isis.applib.fixtures.AbstractFixture;
import org.apache.isis.applib.value.Date;

public abstract class AbstractCustomerFixture extends AbstractFixture {

	protected Customer createCustomer(String ppsn, CustomerTitle customerTitle,
			String firstName, String surname, String mothersBirthSurname,
			String pin, Date dateOfBirth, String phoneNumber,
			String mobileNumber, String emailAddress,
			Language language, int numberOfDependentChildren,
			boolean goPaperFree) {

		// customer, name, credentials
		Customer customer = newTransientInstance(Customer.class);
		customer.setPpsn(ppsn);

		CustomerCredentials credentials = newTransientInstance(CustomerCredentials.class);
		credentials.setMothersMaidenSurname(mothersBirthSurname);
		credentials.setRevenuePin(pin);

		customer.setCredentials(credentials);
		credentials.setCustomer(customer);

		// profile, name
		CustomerProfile profile = newTransientInstance(CustomerProfile.class);
		customer.setProfile(profile);
		profile.setCustomer(customer);

		CustomerName name = newTransientInstance(CustomerName.class);
		profile.setName(name);
		name.setFirstName(firstName);
		name.setSurname(surname);
		name.setTitle(customerTitle);

		// requests history
		CorrespondenceHistory requestsHistory = newTransientInstance(CorrespondenceHistory.class);
		requestsHistory.setCustomer(customer);
		customer.setCorrespondenceHistory(requestsHistory);

		// tax record
		TaxRecord taxRecord = newTransientInstance(TaxRecord.class);
		taxRecord.setCustomer(customer);
		customer.setTaxRecord(taxRecord);

		getContainer().persist(customer);
		
		return customer;
	}

	protected void addCustomerTaxCredit(Customer customer, int year,
			String taxCreditTypeCode) {
		TaxRecord taxRecord = customer.getTaxRecord();
		CustomerTaxYear cty = newTransientInstance(CustomerTaxYear.class);
		cty.setTaxRecord(taxRecord);
		
		List<CustomerTaxYear> taxYears = taxRecord.getTaxYears();
		cty.setTaxCreditRate(taxCreditRateFor(year, taxCreditTypeCode));
		taxYears.add(cty);
		getContainer().persist(cty);
	}

	private TaxCreditRate taxCreditRateFor(int year, String taxCreditTypeCode) {
		return TaxCreditRate.lookup(TaxYear.lookup(year, getContainer()), TaxCreditType.lookup(taxCreditTypeCode, getContainer()), getContainer());
	}

}