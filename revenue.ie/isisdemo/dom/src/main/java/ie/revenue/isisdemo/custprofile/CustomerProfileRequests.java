package ie.revenue.isisdemo.custprofile;

import ie.revenue.isisdemo.corresp.CorrespondenceType;
import ie.revenue.isisdemo.corresp.incoming.CustomerRequest;
import ie.revenue.isisdemo.customers.Customer;
import ie.revenue.isisdemo.util.PropertiesIgnoringNullValue;

import java.util.Properties;

import org.apache.isis.applib.AbstractService;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;

@Hidden
@Named("Requests")
public class CustomerProfileRequests extends AbstractService {

    // {{ Id, iconName
    @Override
    public String getId() {
        return "customerProfileRequests";
    }

    public String iconName() {
        return "CustomerProfileRequest";
    }
    // }}
    
	// {{ updateEmailAddress (action)
	@MemberOrder(sequence = "1")
	public void updateEmailAddress(
			CustomerProfile customerProfile, 
			@Named("Email address") final String emailAddress) {
		CorrespondenceType correspondenceType = CorrespondenceType.lookup("EML", getContainer());
		correspondenceType.createRequest(customerProfile.getCustomer(), emailAddress);
	}
	
	public static class UpdateEmailAddressCommand implements CustomerRequest.Command {
		public Properties propertiesFor(Customer customer, String... args) {
			Properties properties = new PropertiesIgnoringNullValue();
			properties.put("emailAddress", args[0]);
			return properties;
		}

		@Override
		public void apply(Customer customer, Properties properties) {
			String emailAddress = properties.getProperty("emailAddress");
			CustomerProfile customerProfile = profiles.profileFor(customer);
			customerProfile.setEmailAddress(emailAddress);
		}
		
		// {{ injected: CustomerProfiles
		private CustomerProfiles profiles;

		public void setCustomerProfiles(final CustomerProfiles profiles) {
			this.profiles = profiles;
		}
		// }}
	}
	// }}

	// {{ updateAddress (action)
	@MemberOrder(sequence = "1")
	public void updateAddress(
			CustomerProfile customerProfile, 
			@Named("Street 1") final String street1,
			@Optional
			@Named("Street 2") final String street2, 
			@Named("Town") final String town, 
			@Named("County") final String county 
			) {
		CorrespondenceType correspondenceType = CorrespondenceType.lookup("ADR", getContainer());
		correspondenceType.createRequest(customerProfile.getCustomer(), street1, street2, town, county);
	}
	
	public static class UpdateAddressCommand implements CustomerRequest.Command {
		public Properties propertiesFor(Customer customer, String... args) {
			Properties properties = new PropertiesIgnoringNullValue();
			properties.put("street1", args[0]);
			properties.put("street2", args[1]);
			properties.put("town", args[2]);
			properties.put("county", args[3]);
			return properties;
		}

		@Override
		public void apply(Customer customer, Properties properties) {
			String street1 = properties.getProperty("street1");
			String street2 = properties.getProperty("street2");
			String county = properties.getProperty("county");
			String town = properties.getProperty("town");
			CustomerProfile customerProfile = profiles.profileFor(customer);
			Address address = container.newTransientInstance(Address.class);
			address.setStreet1(street1);
			address.setStreet2(street2);
			address.setCounty(county);
			address.setTown(town);
			container.persist(address);
			customerProfile.setAddress(address);
		}
		
		// {{ injected: DomainObjectContainer
		private DomainObjectContainer container;

		public void setDomainObjectContainer(final DomainObjectContainer container) {
			this.container = container;
		}
		// }}


		// {{ injected: CustomerProfiles
		private CustomerProfiles profiles;

		public void setCustomerProfiles(final CustomerProfiles profiles) {
			this.profiles = profiles;
		}
		// }}
	}
	// }}

}
