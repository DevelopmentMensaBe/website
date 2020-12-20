package be.mensa.module.schema.event;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import be.mensa.module.schema.common.Address;
import be.mensa.module.schema.security.Member;
import ci.intern.module.database.schema.main.MainTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Event extends MainTable {

	@ManyToMany
	Set<Member> members;

	String groupName, name;

	@OneToOne
	Address address;

	LocalDateTime start, end;

	Boolean active;

	@Lob
	String description;
}