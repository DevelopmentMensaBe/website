package be.mensa.application.website.view.session;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import be.mensa.application.website.business.logic.TranslationLogic;
import be.mensa.application.website.data.schema.fixed.Language;

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

	@Inject
	TranslationLogic translationLogic;

	/**
	 * Setting loggedIn flag to true
	 */
	@GET
	@Path("logIn")
	@PermitAll
	public void logIn() {

		loggedIn = true;
	}

	/**
	 * Setting loggedIn flag to true
	 */
	@GET
	@Path("checkLoggedIn")
	@PermitAll
	public boolean checkLoggedIn() {

		return loggedIn;
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

	public String translate(String name) {

		return translationLogic.translate(name, Language.valueOf(getCookie("language")));

	}

	public String getCookie(String name) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		Cookie cookie = null;

		Cookie[] userCookies = request.getCookies();
		if (userCookies != null && userCookies.length > 0) {
			for (Cookie element : userCookies) {
				if (element.getName().equals(name)) {
					cookie = element;
					return cookie.getValue();
				}
			}
		}
		return "english";
	}
}