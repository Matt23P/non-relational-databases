package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Academic.class)
public abstract class Academic_ extends model.Sitter_ {

	public static volatile SingularAttribute<Academic, Integer> max_age;
	public static volatile SingularAttribute<Academic, String> subject;
	public static volatile SingularAttribute<Academic, Double> bonus;

	public static final String MAX_AGE = "max_age";
	public static final String SUBJECT = "subject";
	public static final String BONUS = "bonus";

}

