package it.addon.bigdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // Create properties object manually
        // Properties connConfig = new Properties();
        // connConfig.setProperty("user", "db_user");
        // connConfig.setProperty("password", "db_user_password");

        try {
            // Charger la config
            InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties");
            Properties connConfig = new Properties();
            connConfig.load(input);

            // Initialiser la connexion
            Connection conn = DriverManager.getConnection(
                    connConfig.getProperty("db"), connConfig);

            // Traitement
            Statement stmt = conn.createStatement();
            // Req en BDD
            String req = "SELECT * FROM `contacts` LIMIT 50;";
            // Execute query
            ResultSet rs = stmt.executeQuery(req);
            // Display
            while(rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}