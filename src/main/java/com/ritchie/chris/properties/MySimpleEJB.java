package com.ritchie.chris.properties;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MySimpleEJB {

    @Inject
    @ApplicationProperty(name = "docs.dir")
    private String myProperty;
    
    public String getProperty() {
        return myProperty;
    }
    
}
