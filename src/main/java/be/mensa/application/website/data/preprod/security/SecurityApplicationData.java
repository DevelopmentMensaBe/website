/**
 *
 */
package be.mensa.application.website.data.preprod.security;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import be.mensa.application.website.data.operator.security.UserOperator;
import be.mensa.application.website.data.schema.dynamic.person.Person;
import be.mensa.application.website.data.schema.dynamic.security.ApplicationUser;
import be.mensa.application.website.data.schema.fixed.Gender;
import be.mensa.application.website.data.schema.fixed.Role;

/**
 * Generates security test data
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Dependent
public class SecurityApplicationData {

	@Inject
	UserOperator userOperator;

	/**
	 * Generates the test data...
	 */
	public void generateData() {

		var person = new Person();

		person.setFirstName("First name");
		person.setLastName("Last name");
		person.setGender(Gender.Male);

		userOperator.add(
				new ApplicationUser(person, "mbe", "7iaw3Ur350mqGo7jwQrpkj9hiYB3Lkc/iBml1JQODbJ6wYX4oOHV+E+IvIh/1nsUNzLDBMxfqa2Ob1f1ACio/w==", Role.member));

		person = new Person();

		person.setFirstName("Fabrizio");
		person.setLastName("Usai");
		person.setGender(Gender.Male);

		userOperator.add(
				new ApplicationUser(person, "fusai", "7iaw3Ur350mqGo7jwQrpkj9hiYB3Lkc/iBml1JQODbJ6wYX4oOHV+E+IvIh/1nsUNzLDBMxfqa2Ob1f1ACio/w==", Role.admin));

		person = new Person();

		person.setFirstName("Tom");
		person.setLastName("De Pryck");
		person.setGender(Gender.Male);

		userOperator.add(new ApplicationUser(person, "tdepryck", "7iaw3Ur350mqGo7jwQrpkj9hiYB3Lkc/iBml1JQODbJ6wYX4oOHV+E+IvIh/1nsUNzLDBMxfqa2Ob1f1ACio/w==",
				Role.board));

		person = new Person();

		person.setFirstName("Niki");
		person.setLastName("Morena");
		person.setGender(Gender.Female);

		userOperator.add(new ApplicationUser(person, "nmorena", "7iaw3Ur350mqGo7jwQrpkj9hiYB3Lkc/iBml1JQODbJ6wYX4oOHV+E+IvIh/1nsUNzLDBMxfqa2Ob1f1ACio/w==",
				Role.visitor));
	}
}