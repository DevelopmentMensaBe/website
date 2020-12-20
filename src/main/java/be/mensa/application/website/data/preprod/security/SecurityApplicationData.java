/**
 *
 */
package be.mensa.application.website.data.preprod.security;

import java.time.LocalDate;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import be.mensa.application.website.data.operator.security.MemberOperator;
import be.mensa.module.core.enums.Gender;
import be.mensa.module.core.enums.Role;
import be.mensa.module.core.enums.Title;
import be.mensa.module.schema.common.Address;
import be.mensa.module.schema.common.Contact;
import be.mensa.module.schema.person.Person;
import be.mensa.module.schema.security.Member;

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
	MemberOperator memberOperator;

	/**
	 * Generates the test data...
	 */
	public void generateData() {

		var person = new Person();

		person.setFirstName("First name");
		person.setLastName("Last name");
		person.setTitle(Title.sir);
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

		var member = new Member(person, "mbe", "7iaw3Ur350mqGo7jwQrpkj9hiYB3Lkc/iBml1JQODbJ6wYX4oOHV+E+IvIh/1nsUNzLDBMxfqa2Ob1f1ACio/w==");

		member.setRole(Role.member);

		memberOperator.add(member);
	}
}