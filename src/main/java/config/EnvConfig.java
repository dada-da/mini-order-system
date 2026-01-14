package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = EnvConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find application.properties");
            }

            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Error loading config", ex);
        }
    }

    public static String getDbUrl() {
        return properties.getProperty("db.url");
    }

    public static String getDbUser() {
        return properties.getProperty("db.username");
    }

    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }
}
