/**
 *
 */
package be.mensa.application.website.data.preprod.security;

import java.time.LocalDate;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import be.mensa.application.website.data.operator.security.UserOperator;
import be.mensa.application.website.data.schema.dynamic.common.Address;
import be.mensa.application.website.data.schema.dynamic.common.Contact;
import be.mensa.application.website.data.schema.dynamic.person.Person;
import be.mensa.application.website.data.schema.dynamic.security.ApplicationUser;
import be.mensa.application.website.data.schema.fixed.Gender;
import be.mensa.application.website.data.schema.fixed.Language;
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
		person.setGender(Gender.Other);
		person.setBirthDate(LocalDate.now().minusDays(1));

		var contact = new Contact();

		contact.setEmail("test@donttest.fake");
		contact.setWebsite("www.mensa.be");

		var address = new Address();

		address.setStreet("Park Avenue");
		address.setNumber("1");
		address.setCity("Amsterdam");
		address.setZipCode("1000");

		contact.setAddress(address);

		person.setContact(contact);

		userOperator.add(new ApplicationUser(person, "mbe", "MBE1234",
				"7iaw3Ur350mqGo7jwQrpkj9hiYB3Lkc/iBml1JQODbJ6wYX4oOHV+E+IvIh/1nsUNzLDBMxfqa2Ob1f1ACio/w==", Role.member, Language.english));

		person = new Person();

		person.setFirstName("Fabrizio");
		person.setLastName("Usai");
		person.setGender(Gender.Male);

		userOperator.add(new ApplicationUser(person, "fusai", "MBE4248",
				"7iaw3Ur350mqGo7jwQrpkj9hiYB3Lkc/iBml1JQODbJ6wYX4oOHV+E+IvIh/1nsUNzLDBMxfqa2Ob1f1ACio/w==", Role.admin, Language.dutch));

		person = new Person();

		person.setFirstName("Tom");
		person.setLastName("De Pryck");
		person.setGender(Gender.Male);

		userOperator.add(new ApplicationUser(person, "tdepryck", "MBE0001",
				"7iaw3Ur350mqGo7jwQrpkj9hiYB3Lkc/iBml1JQODbJ6wYX4oOHV+E+IvIh/1nsUNzLDBMxfqa2Ob1f1ACio/w==", Role.board, Language.french));

		person = new Person();

		person.setFirstName("Niki");
		person.setLastName("Morena");
		person.setGender(Gender.Female);

		userOperator.add(new ApplicationUser(person, "nmorena", "MBE4444",
				"7iaw3Ur350mqGo7jwQrpkj9hiYB3Lkc/iBml1JQODbJ6wYX4oOHV+E+IvIh/1nsUNzLDBMxfqa2Ob1f1ACio/w==", Role.visitor, Language.german));
	}
}