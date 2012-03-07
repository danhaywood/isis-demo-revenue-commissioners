package ie.revenue.isisdemo.corresp;

import ie.revenue.isisdemo.custprofile.CustomerProfileRequests;
import ie.revenue.isisdemo.taxrecord.CustomerTaxYear;

import org.apache.isis.applib.fixtures.AbstractFixture;

public class CorrespondenceTypeFixture extends AbstractFixture {


	@Override
	public void install() {
		createCorrespondenceType("EML", "Update Email Address", CorrespondenceDirection.Incoming, CustomerProfileRequests.UpdateEmailAddressCommand.class);
		createCorrespondenceType("ADR", "Update Address", CorrespondenceDirection.Incoming, CustomerProfileRequests.UpdateAddressCommand.class);
		createCorrespondenceType("CLM", "Claim Tax Credit", CorrespondenceDirection.Incoming, CustomerTaxYear.ClaimTaxCreditCommand.class);
		createCorrespondenceType("TAX", "Tax Record", CorrespondenceDirection.Outgoing, null);
	}

	private CorrespondenceType createCorrespondenceType(String code, String name, CorrespondenceDirection direction, Class<?> commandClass) {
		CorrespondenceType correspondenceType = newTransientInstance(CorrespondenceType.class);
		correspondenceType.setCode(code);
		correspondenceType.setName(name);
		correspondenceType.setDirection(direction);
		if(commandClass != null) {
			correspondenceType.setCommandClassName(commandClass.getName());
		}
		
		getContainer().persist(correspondenceType);
		
		return correspondenceType;
	}

}