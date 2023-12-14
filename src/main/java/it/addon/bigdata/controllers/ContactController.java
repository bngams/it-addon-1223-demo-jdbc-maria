package it.addon.bigdata.controllers;

import it.addon.bigdata.data.dao.ContactDAO;
import it.addon.bigdata.models.Contact;
import it.addon.bigdata.services.ContactService;

import java.sql.SQLException;
import java.util.List;

public class ContactController {

    public ContactController() {
        try {
            // classes données
            List<Contact> contacts = ContactDAO.findAll(0);
            // classes services
            ContactService cs = new ContactService();
            List<Contact> contactsFromService  =cs.findAllContacts(0);
            System.out.println("Done");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
