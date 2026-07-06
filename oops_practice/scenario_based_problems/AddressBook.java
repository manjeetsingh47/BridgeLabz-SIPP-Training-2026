package oops_practice.scenario_based_problems;

import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               ", Phone: " + phone +
               ", Email: " + email;
    }
}

public class AddressBook {

    static ArrayList<Contact> contacts = new ArrayList<>();
    static HashMap<String, Contact> contactMap = new HashMap<>();
    static HashSet<String> phoneSet = new HashSet<>();

    static void addContact(String name, String phone, String email) {

        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number. Contact not added.");
            return;
        }

        Contact c = new Contact(name, phone, email);

        contacts.add(c);
        contactMap.put(name, c);
        phoneSet.add(phone);

        System.out.println("Contact added successfully.");
    }

    static void searchContact(String name) {

        Contact c = contactMap.get(name);

        if (c != null)
            System.out.println(c);
        else
            System.out.println("Contact not found.");
    }

    static void deleteContact(String name) {

        Contact c = contactMap.remove(name);

        if (c != null) {
            contacts.remove(c);
            phoneSet.remove(c.phone);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    static void displayContacts() {

        Collections.sort(contacts, (c1, c2) -> c1.name.compareToIgnoreCase(c2.name));

        System.out.println("\nContacts:");

        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {

        addContact("Manjeet", "9876543210", "manjeet@gmail.com");
        addContact("Aman", "9123456789", "aman@gmail.com");
        addContact("Riya", "9988776655", "riya@gmail.com");

        addContact("Rahul", "9876543210", "rahul@gmail.com");

        System.out.println();

        searchContact("Aman");

        System.out.println();

        deleteContact("Riya");

        displayContacts();
    }
}