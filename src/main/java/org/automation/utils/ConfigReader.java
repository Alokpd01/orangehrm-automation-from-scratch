package org.automation.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader(){
        properties = new Properties();
        try{
            InputStream inputStream = new FileInputStream("configuration/Configuration.properties");
            properties.load(inputStream);
        }catch (Exception e){
            System.out.println("Unable to load the configuration file: " + e.getMessage());
        }
    }

    public String getUrl(){
        return properties.getProperty("baseUrl");
    }

    public String getBrowser(){
        return properties.getProperty("browser");
    }

    public String getScreen(){
        return properties.getProperty("screen");
    }

    public String getHeadless(){
        return properties.getProperty("headless");
    }

    public String getUsername(){
        return properties.getProperty("username");
    }

    public String getPassword(){
        return properties.getProperty("password");
    }

    public long getTimeout(){
        return Long.parseLong(properties.getProperty("timeout"));
    }
}
