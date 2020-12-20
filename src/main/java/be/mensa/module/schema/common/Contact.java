package be.mensa.module.schema.common;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Embeddable
public class Contact {

	String email, phone, mobile;

	@Lob
	String website;

	@OneToOne(cascade = CascadeType.ALL)
	Address address = new Address();
}