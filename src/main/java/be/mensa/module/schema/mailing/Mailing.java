package be.mensa.module.schema.mailing;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import ci.intern.module.database.schema.main.MainTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Mailing extends MainTable {

	@ManyToOne
	Email email;

	String title;

	@Lob
	String content;

	LocalDateTime sent;
}