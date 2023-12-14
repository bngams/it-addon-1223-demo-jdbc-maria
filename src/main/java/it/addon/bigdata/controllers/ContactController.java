package it.addon.bigdata.controllers;

import it.addon.bigdata.data.dao.ContactDAO;
import it.addon.bigdata.models.Contact;
import it.addon.bigdata.services.ContactService;

import java.sql.SQLException;
import java.util.List;

public class ContactController {

    private final ContactService cs;

    public ContactController() {
        this.cs = new ContactService();
    }

    public void findAllContacts() {
        try {
            // classes données
            List<Contact> contacts = ContactDAO.findAll(0);
            // classes services
            List<Contact> contactsFromService  = this.cs.findAllContacts(0);
            System.out.println("Done");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
