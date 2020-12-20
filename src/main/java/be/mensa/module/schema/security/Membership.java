package be.mensa.module.schema.security;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import be.mensa.module.core.enums.MemberShipStatus;
import be.mensa.module.core.enums.PaymentMethod;
import ci.intern.module.database.schema.main.MainTable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Membership extends MainTable {

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	MemberShipStatus memberShipStatus;

	LocalDate start, end, payment, welcomeMail, cardSent;

	boolean life, printSubscription;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	PaymentMethod paymentMethod;

}