package it.addon.bigdata.services;

import it.addon.bigdata.data.dao.ContactDAO;
import it.addon.bigdata.models.Contact;

import java.sql.SQLException;
import java.util.List;

public class ContactService {

    public List<Contact> findAllContacts(Integer limit) throws SQLException {
        return ContactDAO.findAll(0);
    }
}
