package be.mensa.module.schema.person;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

import be.mensa.module.core.ApplicationConstants;
import be.mensa.module.core.enums.Gender;
import be.mensa.module.core.enums.Title;
import be.mensa.module.schema.common.Contact;
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
	Title title;

	@NonNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	Gender gender;

	@JsonbDateFormat(ApplicationConstants.DATE_FORMAT)
	LocalDate birthDate;

	String bloodType, profession, education;

	Boolean married;

	Integer children, mbti;

	@Lob
	String remark;

	@Embedded
	Contact contact = new Contact();

	@Tolerate
	public Person() { // No-arg constructor for JPA mandatory
	}

	@Override
	public String toString() {

		return firstName + " " + lastName;
	}
}