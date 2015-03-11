package com.ritchie.chris.properties;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

public class ApplicaitonPropertyProducer {

    @Inject
    private PropertyFileResolver fileResolver;

    @Produces
    @ApplicationProperty(name = "")
    public String getPropertyAsString(InjectionPoint injectionPoint) {
        
        String propertyName = injectionPoint.getAnnotated().getAnnotation(ApplicationProperty.class).name();
        String value = fileResolver.getProperty(propertyName);
        
        if (value == null || propertyName.trim().length() == 0) {
            throw new IllegalArgumentException("No property found with name " + value);
        }
        return value;
        
    }
    
    @Produces
    @ApplicationProperty(name="")
    public Integer getPropertyAsInteger(InjectionPoint injectionPoint) {
        
        String value = getPropertyAsString(injectionPoint);
        return value == null ? null : Integer.valueOf(value);
    }

}
