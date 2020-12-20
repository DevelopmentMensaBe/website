package be.mensa.module.schema.person;

import javax.management.relation.RelationType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import be.mensa.module.schema.security.Member;
import ci.intern.module.database.schema.main.MainTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Relation extends MainTable {

	@ManyToOne
	Member member;

	@OneToOne
	Member relatedMember;

	RelationType relationType;
}