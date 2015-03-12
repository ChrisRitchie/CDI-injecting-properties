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
     
    private Map<String, String> properties = new HashMap<>();
     
    @PostConstruct
    private void init() throws IOException {
         
        //matches the property name as defined in the system-properties element in WildFly
        String propertyFile = System.getProperty("application.properties");
        File file = new File(propertyFile);
        Properties properties = new Properties();
         
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            System.out.println("Unable to load properties file" + e);
        }
         
        HashMap hashMap = new HashMap<>(properties);
        this.properties.putAll(hashMap);
    }
 
    public String getProperty(String key) {
        return properties.get(key);
    }
}
