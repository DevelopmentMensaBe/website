package be.mensa.module.schema.common;

import java.util.Optional;

import javax.persistence.Entity;

import ci.intern.module.database.schema.main.MainTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents the Address table in the database. Location is the identifier for the address, like Headquarters.
 *
 * @author Fabrizio Usai
 *
 * @since 1.0.0
 *
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Address extends MainTable {

	String location, street, number, zipCode, city, bus, country;

	Double longitude = 0.0, latitude = 0.0;

	/*
	 * Make a human readable address representation, like on a letter
	 *
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return street + (Optional.ofNullable(number).isPresent() && !number.isEmpty() ? " " + number : "")
				+ (Optional.ofNullable(bus).isPresent() && !bus.isEmpty() ? " " + bus : "") + ", " + zipCode + " " + city
				+ (Optional.ofNullable(country).isPresent() && !country.strip().isEmpty() ? ", " + country : "");
	}
}