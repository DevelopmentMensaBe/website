package be.mensa.application.website.business.logic;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.mensa.application.website.data.operator.security.UserOperator;

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
@Path("users")
public class UserLogic {

	@Resource
	SessionContext sessionContext;

	@Inject
	Instance<UserOperator> userOperator;

	@PermitAll
	public String getWelcomeMessage() {

		return "Welkom bezoeker";
	}

	@RolesAllowed({ "member", "admin", "board" })
	public String getMemberMessage() {

		return "Hallo lid van Mensa: " + sessionContext.getCallerPrincipal().getName();
	}

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public Response getUsers() {

		return Response.ok().entity(userOperator.get().collect()).header("Access-Control-Allow-Origin", "*").build();
	}
}
