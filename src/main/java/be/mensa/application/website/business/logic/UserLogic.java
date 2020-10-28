package be.mensa.application.website.business.logic;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * Contains common application information.
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Named
@Stateless
public class UserLogic {

	@RolesAllowed({ "member" })
	public String getMemberMessage() {

		return "Hey member";
	}

	@PermitAll
	public String getWelcomeMessage() {

		return "Hey guest";
	}
}
