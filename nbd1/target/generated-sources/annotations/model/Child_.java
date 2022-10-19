package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Child.class)
public abstract class Child_ extends model.Parent_ {

	public static volatile SingularAttribute<Child, String> childName;
	public static volatile SingularAttribute<Child, Integer> childAge;

	public static final String CHILD_NAME = "childName";
	public static final String CHILD_AGE = "childAge";

}

