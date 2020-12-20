package be.mensa.module.schema.mailing;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import be.mensa.module.core.enums.EmailType;
import be.mensa.module.core.enums.Visibility;
import be.mensa.module.schema.person.Person;
import ci.intern.module.database.schema.main.MainTable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(of = "address")
public class Email extends MainTable {

	@ManyToOne
	Person person;

	@Enumerated(EnumType.STRING)
	EmailType emailType;

	String address;

	Boolean emailPrimary;

	@Enumerated(EnumType.STRING)
	Visibility visibility;
}