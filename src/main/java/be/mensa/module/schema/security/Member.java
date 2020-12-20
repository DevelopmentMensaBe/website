package be.mensa.module.schema.security;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import be.mensa.module.core.enums.Role;
import be.mensa.module.core.enums.Visibility;
import be.mensa.module.core.enums.WebsiteLanguage;
import be.mensa.module.schema.audit.AuditTable;
import be.mensa.module.schema.person.Person;
import be.mensa.module.schema.person.Relation;
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
@ToString(of = { "username", "role" })
public class Member extends AuditTable {

	@NonNull
	@OneToOne(cascade = CascadeType.ALL)
	Person person;

	@NonNull
	@Column(nullable = false, unique = true)
	String username;

	@NonNull
	@Column(nullable = false)
	String password;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	Role role = Role.visitor;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	WebsiteLanguage language = WebsiteLanguage.english;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	Visibility visibility = Visibility.none;

	LocalDateTime lastLogin;

	String emailMensaInt;

	@OneToMany(mappedBy = "member")
	Set<Relation> relations;

	@Tolerate
	public Member() { // No-arg constructor for JPA is mandatory
	}
}