package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Parent.class)
public abstract class Parent_ extends model.AbstractEntity_ {

	public static volatile SingularAttribute<Parent, String> address;
	public static volatile SingularAttribute<Parent, String> phoneNumber;
	public static volatile SingularAttribute<Parent, String> name;
	public static volatile SingularAttribute<Parent, Long> parentId;

	public static final String ADDRESS = "address";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String NAME = "name";
	public static final String PARENT_ID = "parentId";

}

