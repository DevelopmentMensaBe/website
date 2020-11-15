package be.mensa.application.website.view.session;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Represents all security data for a user during a session.
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Named
@SessionScoped
@Path("session")
public class UserSession implements Serializable {

	private static final long serialVersionUID = -757261925450427516L;

	private boolean loggedIn = false;

	/**
	 * Setting loggedIn flag to true
	 */
	@GET
	@Path("logIn")
	@PermitAll
	public Response logIn() {

		loggedIn = true;

		return Response.ok().header("Access-Control-Allow-Origin", "*").build();
	}

	/**
	 * Setting loggedIn flag to true
	 */
	@GET
	@Path("checkLoggedIn")
	@PermitAll
	public Response checkLoggedIn() {

		return Response.ok().entity(loggedIn).header("Access-Control-Allow-Origin", "*").build();
	}

	/**
	 * Log out of application
	 *
	 * @throws ServletException
	 * @throws IOException
	 */
	@PermitAll
	public void logOut() throws ServletException, IOException {

		loggedIn = false;

		var externalContext = FacesContext.getCurrentInstance().getExternalContext();

		((HttpSession) externalContext.getSession(false)).invalidate();

		((HttpServletRequest) externalContext.getRequest()).logout();
	}
}