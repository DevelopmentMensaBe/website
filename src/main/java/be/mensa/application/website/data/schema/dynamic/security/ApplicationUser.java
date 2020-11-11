package be.mensa.application.website.data.schema.dynamic.security;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

import be.mensa.application.website.data.schema.dynamic.person.Person;
import be.mensa.application.website.data.schema.fixed.Role;
import ci.intern.module.database.schema.main.MainTable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * Represents the CjmUser table in the database.
 * 
 * @author Fabrizio Usai
 * 
 * @since 1.0.0
 * 
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true, of = { "username", "role" })
@ToString(callSuper = true, of = { "username", "role" })
public class ApplicationUser extends MainTable {

	@NonNull
	@OneToOne(cascade = CascadeType.ALL)
	Person person;

	@NonNull
	@Column(nullable = false, unique = true)
	String username;

	@NonNull
	@Column(nullable = false)
	String password;

	@NonNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	Role role;

	@Tolerate
	public ApplicationUser() { // No-arg constructor for JPA is mandatory
	}
}