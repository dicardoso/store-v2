package br.edu.ifpb.padroes.configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class ApplicationConfiguration {

    // The field must be declared volatile so that double check lock would work
    // correctly.
    private static volatile ApplicationConfiguration instance;

    Map<String, String> properties = new HashMap<>();

    private static Logger log = Logger.getLogger(ApplicationConfiguration.class.getName());

    private ApplicationConfiguration() throws IOException {
        String propFileName = "application.properties";
        Properties prop = new Properties();
        InputStream inputStream = ApplicationConfiguration.class.getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        for (Map.Entry<Object, Object> objectObjectEntry : prop.entrySet()) {
            properties.put(objectObjectEntry.getKey().toString(), objectObjectEntry.getValue().toString());
        }

    }

    public static ApplicationConfiguration getInstance() {
        ApplicationConfiguration result = instance;
        if (result != null) {
            return result;
        }
        synchronized(ApplicationConfiguration.class) {
            if (instance == null) {
                try {
                    instance = new ApplicationConfiguration();
                } catch (IOException e) {
                    log.throwing(ApplicationConfiguration.class.getName(), "getInstance()", e);
                }
            }
            return instance;
        }
    }

    public Map<String, String> getProperties() {
        return properties;
    }

}
