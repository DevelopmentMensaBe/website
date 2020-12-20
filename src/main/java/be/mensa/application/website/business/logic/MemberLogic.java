package be.mensa.application.website.business.logic;

import java.text.MessageFormat;
import java.util.Set;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import be.mensa.application.website.data.operator.security.MemberOperator;
import be.mensa.module.core.enums.WebsiteLanguage;
import be.mensa.module.schema.security.Member;

/**
 * Contains common application information.
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Stateless
@Path("user")
public class MemberLogic {

	@Resource
	SessionContext sessionContext;

	@Inject
	Instance<MemberOperator> memberOperator;

	@Inject
	TranslationLogic translationLogic;

	@GET
	@Path("message")
	@RolesAllowed({ "member", "admin", "board" })
	public String getMemberMessage() {

		var member = memberOperator.get().findUser(sessionContext.getCallerPrincipal().getName());

		return MessageFormat.format(translationLogic.translate("content.member.message", member.getLanguage()), member.getUsername());

	}

	@GET
	@Path("loggedInUser")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public Member getLoggedInUser() {

		return memberOperator.get().findUser(sessionContext.getCallerPrincipal().getName());
	}

	@GET
	@Path("language")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public String getLanguage() {

		if (!sessionContext.getCallerPrincipal().getName().equals("anonymous"))
			return memberOperator.get().findUser(sessionContext.getCallerPrincipal().getName()).getLanguage().toString();
		return null;

	}

	@GET
	@Path("changeLanguage/{language}")
	@PermitAll
	public void changeLanguage(@PathParam(value = "language") String language) {

		var applicationUser = memberOperator.get().findUser(sessionContext.getCallerPrincipal().getName());

		applicationUser.setLanguage(WebsiteLanguage.valueOf(language));

		memberOperator.get().save(applicationUser);
	}

	@POST
	@Path("save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PermitAll
	public Member saveUser(Member member) {

		return memberOperator.get().save(member);
	}

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	@PermitAll
	public Set<Member> getUsers() {

		return memberOperator.get().collect();
	}
}
