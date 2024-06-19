package com.github.peaquyen.com.xjournal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static final Logger logger = Logger.getLogger(DBConnection.class.getName());
    private static Connection connection;

    static {
        try {
            Properties properties = new Properties();
            properties.load(DBConnection.class.getClassLoader().getResourceAsStream("config.properties"));

            String url = "jdbc:mysql://" + properties.getProperty("db.host") + "/" + properties.getProperty("db.database");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            logger.info("Attempting to connect to the database...");
            connection = DriverManager.getConnection(url, user, password);
            logger.info("Database connection established successfully.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to establish database connection.", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
