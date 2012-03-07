package ie.revenue.isisdemo.corresp.incoming;

import ie.revenue.isisdemo.customers.Customer;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

import org.apache.isis.applib.annotation.Exploration;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Ignore;
import org.apache.isis.applib.annotation.MemberOrder;


public class CustomerRequest extends IncomingCorrespondence {

	public interface Command {
		@Ignore
		Properties propertiesFor(Customer customer, String... args);
		@Ignore
		void apply(Customer customer, Properties properties);
	}

	// {{ Properties (property)
	private String properties;

	@Hidden
	@MemberOrder(sequence = "1")
	public String getProperties() {
		return properties;
	}

	public void setProperties(final String properties) {
		this.properties = properties;
	}

	private Properties asProperties() {
		Properties properties = new Properties();
		try {
			properties.load(new StringReader(getProperties()));
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return properties;
	}
	// }}
	
	// {{ apply (action)
	@MemberOrder(sequence = "1")
	public void apply() {
		Properties properties = asProperties();
		getType().createCommand().apply(getCorrespondenceHistory().getCustomer(), properties);
		setPending(false);
	}
	// }}
	
	// {{ viewProperties (exploration action)
	@Exploration
	@MemberOrder(sequence = "1")
	public String viewProperties() {
		return getProperties();
	}
	// }}

}
