package com.ritchie.chris.properties;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR })
public @interface ApplicationProperty {

    // no default value supplied meaning a value is mandatory
    // @Nonbinding what does this mean
    String name();

}
