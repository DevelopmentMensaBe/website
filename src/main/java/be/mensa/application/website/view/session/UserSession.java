package be.mensa.application.website.view.session;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.Getter;

/**
 * Represents all security data for a user during a session.
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Getter
@Named
@SessionScoped
public class UserSession implements Serializable {

	private static final long serialVersionUID = -757261925450427516L;

	private boolean loggedIn = false;

	/**
	 * Setting loggedIn flag to true
	 */
	public void login() {

		loggedIn = true;
	}

	/**
	 * Log out of application
	 *
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logOut() throws ServletException, IOException {

		loggedIn = false;

		var externalContext = FacesContext.getCurrentInstance().getExternalContext();

		((HttpSession) externalContext.getSession(false)).invalidate();

		((HttpServletRequest) externalContext.getRequest()).logout();

		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), "",
				"/index.html?faces-redirect=true");
	}
}