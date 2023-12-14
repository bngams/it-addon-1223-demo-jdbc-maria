package it.addon.bigdata.data.query;

import it.addon.bigdata.data.source.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {

    public static ResultSet exec(String sql) {
        try {
            // Traitement
            Statement stmt = DBConnection.getConnection().createStatement();
            // Execute query
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
