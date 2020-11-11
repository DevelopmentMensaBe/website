package be.mensa.application.website.data.operator.security;

import javax.enterprise.context.Dependent;

import be.mensa.application.website.data.schema.dynamic.security.ApplicationUser;
import be.mensa.application.website.data.schema.dynamic.security.ApplicationUser_;
import ci.intern.module.database.operator.main.MainOperator;

/**
 * Operates on entities of type <code>ApplicationUser</code>
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Dependent
public class UserOperator extends MainOperator<ApplicationUser> {

	/**
	 * Search user based on given user name.
	 *
	 * @param username
	 * @return found user
	 */
	public ApplicationUser findUser(String username) {

		conditions.add(b.equal(r.get(ApplicationUser_.username), username));

		return find();
	}
}