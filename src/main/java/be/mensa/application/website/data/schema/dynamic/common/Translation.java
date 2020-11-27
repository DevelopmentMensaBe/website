package be.mensa.application.website.data.schema.dynamic.common;

import javax.persistence.Column;
import javax.persistence.Entity;

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

	String nederlands, francais, deutsch;

	public Translation(@NonNull String name, @NonNull String english, String nederlands, String francais, String deutsch) {

		this.name = name;
		this.english = english;
		this.nederlands = nederlands;
		this.francais = francais;
		this.deutsch = deutsch;
	}

	@Tolerate
	public Translation() {
	}
}