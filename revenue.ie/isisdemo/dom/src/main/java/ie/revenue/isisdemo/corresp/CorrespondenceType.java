package ie.revenue.isisdemo.corresp;

import ie.revenue.isisdemo.corresp.incoming.CustomerRequest;
import ie.revenue.isisdemo.corresp.incoming.CustomerRequest.Command;
import ie.revenue.isisdemo.customers.Customer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.isis.applib.AbstractDomainObject;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Ignore;
import org.apache.isis.applib.annotation.Immutable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.filter.Filter;

import com.google.common.base.Objects;

@Immutable
public class CorrespondenceType extends AbstractDomainObject {

	// {{ Code (property)
	private String code;

	@MemberOrder(sequence = "1")
	public String getCode() {
		return code;
	}

	public void setCode(final String code) {
		this.code = code;
	}
	// }}

	// {{ Name (property)
	private String name;

	@Title
	@MemberOrder(sequence = "1")
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	// }}

	// {{ Direction (property)
	private CorrespondenceDirection direction;

	@Title(sequence="2", prepend=" (", append=")")
	@MemberOrder(sequence = "3")
	public CorrespondenceDirection getDirection() {
		return direction;
	}

	public void setDirection(final CorrespondenceDirection direction) {
		this.direction = direction;
	}
	// }}

	// {{ CommandClassName (property)
	private String commandClassName;

	@MemberOrder(sequence = "4")
	public String getCommandClassName() {
		return commandClassName;
	}

	public void setCommandClassName(final String commandClassName) {
		this.commandClassName = commandClassName;
	}
	// }}

	// {{ programmatic
	public static CorrespondenceType lookup(final String code,
			DomainObjectContainer container) {
		return container.firstMatch(CorrespondenceType.class, filterFor(code));
	}

	public static Filter<CorrespondenceType> filterFor(final String code) {
		return new Filter<CorrespondenceType>(){

			@Override
			public boolean accept(CorrespondenceType t) {
				return Objects.equal(t.getCode(), code);
			}};
	}
	// }}

	// {{ programmatic: createRequest
	@Ignore
	public CustomerRequest createRequest(Customer customer, String... args) {
		CustomerRequest customerRequest = getContainer().newTransientInstance(CustomerRequest.class);
		customerRequest.setType(this);
		customerRequest.setCorrespondenceHistory(mailbox.correspondenceHistoryFor(customer));

		customerRequest.setNoticeNumber(mailbox.nextNoticeNumber());
		customerRequest.setPending(true);
		customerRequest.setArchived(false);
		
		String string = createPropertiesFor(customer, args);
		customerRequest.setProperties(string);

		getContainer().persist(customerRequest);
		return customerRequest;
	}

	private String createPropertiesFor(Customer customer, String... args) {
		Properties properties = createCommand().propertiesFor(customer, args);
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		properties.list(pw);
		return sw.toString();
	}

	@Ignore
	public Command createCommand() {
		try {
			@SuppressWarnings("unchecked")
			Class<? extends Command> cls = (Class<? extends Command>) Thread.currentThread().getContextClassLoader().loadClass(getCommandClassName());
			return getContainer().newTransientInstance(cls);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	// {{ injected: Mailbox
	private Mailbox mailbox;

	public void setMailbox(final Mailbox mailbox) {
		this.mailbox = mailbox;
	}
	// }}


	
}
