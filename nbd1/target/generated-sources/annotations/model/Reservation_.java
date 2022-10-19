package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reservation.class)
public abstract class Reservation_ extends model.AbstractEntity_ {

	public static volatile SingularAttribute<Reservation, Long> reservation_id;
	public static volatile SingularAttribute<Reservation, LocalDate> date;
	public static volatile SingularAttribute<Reservation, LocalTime> endHour;
	public static volatile SingularAttribute<Reservation, Parent> parent;
	public static volatile SingularAttribute<Reservation, LocalTime> startHour;
	public static volatile SingularAttribute<Reservation, Sitter> sitter;

	public static final String RESERVATION_ID = "reservation_id";
	public static final String DATE = "date";
	public static final String END_HOUR = "endHour";
	public static final String PARENT = "parent";
	public static final String START_HOUR = "startHour";
	public static final String SITTER = "sitter";

}

