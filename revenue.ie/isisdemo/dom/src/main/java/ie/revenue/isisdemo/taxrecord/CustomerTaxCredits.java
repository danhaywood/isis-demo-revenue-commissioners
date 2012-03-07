package ie.revenue.isisdemo.taxrecord;

import java.util.List;

import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;


/**
 * A slight workaround for SQL OS, that isn't yet able to handle the
 * explicit CustomerTaxCredit class, and attempts to create it as an
 * implicit association table between CustomerTaxYear and TaxCredit.
 * 
 * <p>
 * Ultimately, I think this is due to a lack of modelling support for
 * "inverse" (bidirectional) parent/child mappings.
 */
@Hidden
@Named("Tax Credits")
public interface CustomerTaxCredits {

	List<CustomerTaxCredit> taxCreditsFor(CustomerTaxYear customerTaxYear);
}
