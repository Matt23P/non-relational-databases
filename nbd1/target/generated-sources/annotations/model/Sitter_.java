package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sitter.class)
public abstract class Sitter_ extends model.AbstractEntity_ {

	public static volatile SingularAttribute<Sitter, String> firstName;
	public static volatile SingularAttribute<Sitter, String> lastName;
	public static volatile SingularAttribute<Sitter, Long> sitterId;
	public static volatile SingularAttribute<Sitter, Double> basePrice;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String SITTER_ID = "sitterId";
	public static final String BASE_PRICE = "basePrice";

}

