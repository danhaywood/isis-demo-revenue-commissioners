package ie.revenue.isisdemo.customers;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.filter.Filter;

import com.google.common.base.Objects;

public class Customer extends AbstractDomainObject {

	// {{ Ppsn (property)
	private String ppsn;

	@Disabled
	@Title(sequence = "1", append=": ")
	@MemberOrder(sequence = "1")
	public String getPpsn() {
		return ppsn;
	}

	public void setPpsn(final String ppsn) {
		this.ppsn = ppsn;
	}
	// }}
	
	// {{ Name (derived, maintained property)
	private String name;

	@Title(sequence = "2")
	@MemberOrder(sequence = "2")
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	// }}

	// {{ Credentials (property)
	private CustomerCredentials credentials;

	@Disabled
	@MemberOrder(sequence = "3")
	public CustomerCredentials getCredentials() {
		return credentials;
	}

	public void setCredentials(final CustomerCredentials credentials) {
		this.credentials = credentials;
	}
	// }}
	
	// {{ programmatic: filters
	public static <T extends ReferencesCustomer> Filter<T> filterTo(final Customer customer) {
		return new Filter<T>() {

			@Override
			public boolean accept(final T candidate) {
				String candidatePpsn = candidate.getCustomer().getPpsn();
				String ppsn = customer.getPpsn();
				return Objects.equal(ppsn, candidatePpsn);
			}
		};
	}

	public static Filter<Customer> filterByPpsn(final String ppsn) {
		return new Filter<Customer>() {

			@Override
			public boolean accept(Customer t) {
				return Objects.equal(t.getPpsn(), ppsn);
			}
		};
	}
	// }}

	
}
