package app;

import config.DbConfig;

public class Main {
    public static void main(String[] args) {
        final DbConfig dbConfig = DbConfig.getInstance();

        dbConfig.testDatabaseConnection();
    }
}
