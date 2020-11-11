package be.mensa.application.website.data.schema.dynamic.common;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Embeddable
public class Contact {
	
	String email, phone, mobile;
	
	@Lob
	String website;
	
	@Embedded
	Address address = new Address();

}
