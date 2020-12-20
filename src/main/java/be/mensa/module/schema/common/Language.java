package be.mensa.module.schema.common;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import be.mensa.module.schema.person.Person;
import ci.intern.module.database.schema.main.MainTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Language extends MainTable {

	@ManyToOne
	Person person;

	String name;

	Boolean primaryLanguage;

	@Enumerated(EnumType.STRING)
	Level readLevel;

	@Enumerated(EnumType.STRING)
	Level writtenLevel;

	@Enumerated(EnumType.STRING)
	Level spokenLevel;
}