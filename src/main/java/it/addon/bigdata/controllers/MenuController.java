package it.addon.bigdata.controllers;

import java.util.Scanner;

public class MenuController {

    public MenuController() {
        this.displayMenu();
        this.selectMenu();
    }
    public void displayMenu() {
        System.out.println("Votre choix:");
        System.out.println("0 - Bienvenue");
        System.out.println("1 - Contacts");
    }

    public void selectMenu() {
        Scanner sc = new Scanner(System.in);
        Integer choice = sc.nextInt();
        if(choice == 0) {
            System.out.println("Welcome!!!");
        } else if (choice == 1){
            ContactController ct = new ContactController();
            ct.findAllContacts();
        } else {
            System.out.println("404");
        }
    }
}
