package service;

import java.util.ArrayList;
import model.Contact;

public class ContactManagerService {

    public static ArrayList<Contact> contacts = new ArrayList<>();
    public static int index = 1;

    static {
        contacts.add(new Contact(index++, "Iker Casillas ", "Star", "Spain", "1234567890", "Iker", "Casillas"));
        contacts.add(new Contact(index++, "John Terry ", "Star", "England", "1234567890", "John", "Terry"));
        contacts.add(new Contact(index++, "Raul Gonzalez ", "Star", "Spain", "1234567890", "Raul", "Gonzalez"));

    }

    public void displayAll() {
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");
        contacts.forEach(c -> {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    c.getId(), c.getFullname(),
                    c.getFirstname(), c.getLastname(),
                    c.getGroup(), c.getAddress(), c.getPhone());
        });

    }

    public boolean create(String fullname, String group, String address, String phone) {
        String firstName = fullname.split(" ")[0];
        String lastName = fullname.split(" ")[1];
        return contacts.add(new Contact(index++, fullname, group, address, phone, lastName, firstName));
    }
    public boolean delete(int id){
       return contacts.remove(findById(id));
    }
    public Contact findById(int id){
         for( Contact c: contacts){
            if(c.getId()== id){
                return c;
            }
        }
        return null;
    }
    public boolean exist(int id) {
        for( Contact c: contacts){
            if(c.getId()== id){
                return true;
            }
        }
        return false;
    }



}
