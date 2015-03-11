package com.ritchie.chris.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class PropertyFileResolver {
    
    Map<String, String> properties = new HashMap<>();
    
    @PostConstruct
    private void init() throws IOException {
        
        //lookup our property file location, as defined in the system-properties element in WildFly
        String propertyFile = System.getProperty("application.property");
        File file = new File(propertyFile);
        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        
        properties.putAll(new HashMap<>(properties));

    }

    public String getProperty(String key) {
        return properties.get(key);
    }
    
}
