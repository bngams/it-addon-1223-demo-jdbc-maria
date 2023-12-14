package it.addon.bigdata.data.dao;

import it.addon.bigdata.data.query.Query;
import it.addon.bigdata.models.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public static List<Contact> findAll(Integer limit) throws SQLException {
        String query = "SELECT * FROM `contacts`";
        if(limit > 0) {
            query += " LIMIT " + limit;
            // SELECT * FROM `contacts` LIMIT 10
        }
        ResultSet rs = Query.exec(query);
        // Display
        List<Contact> contacts = new ArrayList<>();
        while(rs.next()) {
            Contact c = new Contact(rs.getInt("id"), rs.getString("name"));
            System.out.println(c.toString());
            contacts.add(c);
        }
        return contacts;
    }
}
