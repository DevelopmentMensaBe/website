package be.mensa.application.website.business.logic;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
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

	@Resource
	SessionContext sessionContext;

	@PermitAll
	public String getWelcomeMessage() {

		return "Welkom bezoeker";
	}

	@RolesAllowed({ "member" })
	public String getMemberMessage() {

		return "Hallo bezoeker " + sessionContext.getCallerPrincipal().getName();
	}
}
