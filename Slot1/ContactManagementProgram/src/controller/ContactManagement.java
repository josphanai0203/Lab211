package controller;

import java.util.ArrayList;
import service.ContactManagerService;
import util.Library;
import view.Menu;

public class ContactManagement extends Menu<String> {

    static String[] menuChoice = {"Add a contact", "Display all contacts", "Delete a contact", "Exit"};

    protected Library library;
    protected ContactManagerService service;

    public ContactManagement() {
        super("Contact Managerment", menuChoice);
        library = new Library();
        service = new ContactManagerService();
    }

    @Override
    public boolean execute(int n) {
        switch (n) {
            case 1:
                create();
                break;
            case 2:
                displayAll();
                break;
            case 3:
                delete();
                break;
            case 4:
                return false;
            default:
                break;
        }
        return true;
    }

    private void create() {
        String fullname = library.getString("Enter Name");
        String group = library.getString("Enter Group");
        String address = library.getString("Enter Address");
        String phone = library.checkInputPhone("Enter Phone");
        if(service.create(fullname, group, address, phone)){
            System.out.println("Create Success");
        }else{
            System.out.println("Create Fail");
        }
    }
    private void displayAll(){
        service.displayAll();
    }
    private void delete(){
       int id = library.getId("Enter ID", (idString)->service.exist(idString), "ID not Found");
        System.out.println(service.findById(id));
        boolean check = library.checkInputYN();
        if(check){
            service.delete(id);
            System.out.println("Successful");
        }else{
            System.out.println("Fail");
        }
    }
   

  

}
