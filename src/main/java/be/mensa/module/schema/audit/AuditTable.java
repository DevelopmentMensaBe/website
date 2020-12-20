package be.mensa.module.schema.audit;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import ci.intern.module.database.schema.main.MainTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public class AuditTable extends MainTable {

	LocalDateTime updateOn;

	String updatedBy;
}
