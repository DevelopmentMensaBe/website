package be.mensa.application.website.data.operator.security;

import javax.enterprise.context.Dependent;

import be.mensa.module.schema.security.Member;
import be.mensa.module.schema.security.Member_;
import ci.intern.module.database.operator.main.MainOperator;

/**
 * Operates on entities of type <code>Member</code>
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Dependent
public class MemberOperator extends MainOperator<Member> {

	/**
	 * Search user based on given user name.
	 *
	 * @param username
	 * @return found user
	 */
	public Member findUser(String username) {

		conditions.add(b.equal(r.get(Member_.username), username));

		return find();
	}
}