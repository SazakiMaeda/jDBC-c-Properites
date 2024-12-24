package main.jdbcPackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

    private static final Properties prop = new Properties();

    private PropertiesFile() {
    }

    static {
        load();
    }

    public static void load() {
        try(InputStream in = PropertiesFile.class
                .getClassLoader().getResourceAsStream("application.properties") ) {
            prop.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
