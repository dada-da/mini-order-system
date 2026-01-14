package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConfig {
    private static DbConfig instance;

    private DbConfig() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("MySQL JDBC Driver not found", ex);
        }
    }

    public static DbConfig getInstance() {
        synchronized (DbConfig.class) {
            if (instance == null) {
                instance = new DbConfig();
            }
        }

        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                EnvConfig.getDbUrl(),
                EnvConfig.getDbUser(),
                EnvConfig.getDbPassword()
        );
    }

    public void closeConnection(Connection conInstance) {
        if (conInstance != null) {
            try {
                conInstance.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public void testDatabaseConnection() {
        try (Connection conn = DriverManager.getConnection(
                EnvConfig.getDbUrl(),
                EnvConfig.getDbUser(),
                EnvConfig.getDbPassword()
        )) {
            System.out.println("Database connection successful");
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
