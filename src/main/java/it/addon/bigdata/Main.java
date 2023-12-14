package it.addon.bigdata;

import it.addon.bigdata.controllers.MenuController;
import it.addon.bigdata.data.dao.ContactDAO;
import it.addon.bigdata.data.query.Query;
import it.addon.bigdata.data.source.DBConnection;
import it.addon.bigdata.data.source.HibernateClient;
import it.addon.bigdata.models.Contact;
import it.addon.bigdata.services.ContactService;
import org.hibernate.SessionFactory;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        withHibernate();
        withoutController();
    }

    static void withHibernate() {
        SessionFactory sf = HibernateClient.getSession();
        sf.inTransaction(session -> {
            session.persist(new Contact(null, "Name 1"));
            session.persist(new Contact(null, "Name 2"));
        });
    }

    static void withController() {
        new MenuController();
    }

    static void withoutController() {
        try {
            // classes données
            List<Contact> contacts = ContactDAO.findAll(0);
            // classes services
            ContactService cs = new ContactService();
            cs.findAllContacts(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}