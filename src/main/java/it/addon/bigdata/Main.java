package it.addon.bigdata;

import it.addon.bigdata.controllers.MenuController;
import it.addon.bigdata.data.dao.ContactDAO;
import it.addon.bigdata.data.source.HibernateClient;
import it.addon.bigdata.entities.Contact;
import it.addon.bigdata.services.ContactService;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        findWithHibernate();
        // withoutController();
    }

    static void findWithHibernate() {
        SessionFactory sf = HibernateClient.getFactory();
        sf.inTransaction(session -> {
            var contacts = session.createSelectionQuery("from Contact", Contact.class).getResultList();
            System.out.println(contacts);
        });
    }

    static void insertWithHibernate() {
        SessionFactory sf = HibernateClient.getFactory();
        sf.inTransaction(session -> {
            session.persist(new Contact( "Name 1"));
            session.persist(new Contact( "Name 2"));
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