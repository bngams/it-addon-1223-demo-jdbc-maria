package it.addon.bigdata.data.source;

import it.addon.bigdata.Main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static Connection conn;

    public static Connection getConnection() {
        if(DBConnection.conn != null) {
            return DBConnection.conn;
        }
        try {
            // Charger la config
            InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties");
            Properties connConfig = new Properties();
            connConfig.load(input);

            // Initialiser la connexion
            DBConnection.conn = DriverManager.getConnection(
                    connConfig.getProperty("db"), connConfig);
            return conn;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
