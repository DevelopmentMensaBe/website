package be.mensa.application.website.data.schema.dynamic.person;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import be.mensa.application.website.data.schema.dynamic.common.Contact;
import be.mensa.application.website.data.schema.fixed.Gender;
import ci.intern.module.database.schema.main.MainTable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Tolerate;

/**
 * Represents the Person table in the database.
 * 
 * @author Fabrizio Usai
 * 
 * @since 1.0.0
 * 
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends MainTable {

	@NonNull
	@Column(nullable = false)
	String firstName, lastName;
	
	@NonNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	Gender gender;

	String nickName;
	
	@Embedded
	Contact contact;

	@Tolerate
	public Person() { // No-arg constructor for JPA mandatory
	}

	@Override
	public String toString() {

		return firstName + " " + lastName;
	}
}