package lesson_15.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDb implements ConnectionDbInterface {
    private static final Logger LOGGER = Logger.getLogger(ConnectionDb.class.getName());
    private static final String DB_URL =
            "jdbc:postgresql://ec2-54-227-243-210.compute-1.amazonaws.com:5432/d71g7a9arrmne3";
    private static final String DB_USERNAME = "zzeeduuxqgwooz";
    private static final String DB_PASSWORD = "284b20acb93f40399f7c9871470e58e5aabc572a1694483cfde436a0ba040a67";
    private static ConnectionDbInterface connectionDBInterface;

    public static ConnectionDbInterface getInstance() {
        if (connectionDBInterface == null) {
            connectionDBInterface = new ConnectionDb();
        }
        return connectionDBInterface;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            LOGGER.log(Level.INFO, "Connection OK");
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.log(Level.INFO, "Connection ERROR");
        }
        return connection;
    }
}
