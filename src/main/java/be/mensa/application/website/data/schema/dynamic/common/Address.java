package be.mensa.application.website.data.schema.dynamic.common;

import java.util.Optional;

import javax.persistence.Embeddable;

import lombok.Data;

/**
 * Represents the Address table in the database. Location is the identifier for the address, like Headquarters.
 * 
 * @author Fabrizio Usai
 * 
 * @since 1.0.0
 * 
 */
@Data
@Embeddable
public class Address {

	String location, street, number, zipCode, city, bus, country;

	Double longitude, latitude;

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