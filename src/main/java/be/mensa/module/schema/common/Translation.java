package be.mensa.module.schema.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import be.mensa.module.core.enums.TranslationType;
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
public class Translation extends MainTable {

	@NonNull
	@Column(nullable = false, unique = true)
	String name;

	@NonNull
	@Column(nullable = false)
	String english;

	String dutch, french, german, code;

	@Enumerated(EnumType.STRING)
	TranslationType translationType;

	public Translation(@NonNull String name, @NonNull String english, String dutch, String french, String german) {

		this.name = name;
		this.english = english;
		this.dutch = dutch;
		this.french = french;
		this.german = german;
	}

	@Tolerate
	public Translation() {
	}
}