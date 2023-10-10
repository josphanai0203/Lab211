package controller;

import java.util.ArrayList;
import service.WorkerManagerService;
import util.Library;
import view.Menu;

public class WorkerManager extends Menu<String> {

    static String[] menuChoice = {"Add Worker", "Up salary", "Down salary", "Display Information salary", "Exit"};

    protected Library library;
    protected WorkerManagerService service;

    public WorkerManager() {
        super("Worker Managerment", menuChoice);
        library = new Library();
        service = new WorkerManagerService();
    }

    @Override
    public boolean execute(int n) {
        switch (n) {
            case 1:
                create();
                break;
            case 2:
                increaseSalary();
                break;
            case 3:
                decreatseSalary();
                break;
            case 4:
                displayALL();
                break;
            case 5:
                return false;
            default:
                break;
        }
        return true;
    }

    public void create() {
        String id = library.getString("Enter Code", idS -> !service.exist(idS), "ID has Exit");
        String name = library.getString("Enter Name");
        int age = library.getInt("Enter Age", 18, 50);
        int salary = library.getInt("Enter Salary");
        String workLocation = library.getString("Enter Location");
        service.create(id, name, age, salary, workLocation);
    }

    public void increaseSalary() {
        String id = library.getString("Enter Code", idS -> service.exist(idS), "ID not Exit");
        int newSalary = library.getInt("Enter New Salary", service.findById(id).getSalary());
        service.upSalary(id, newSalary);
    }
    public void decreatseSalary() {
        String id = library.getString("Enter Code", idS -> service.exist(idS), "ID not Exit");
        int newSalary = library.getInt( service.findById(id).getSalary(),"Enter New Salary");
        service.downSalary(id, newSalary);
    }
    public void displayALL(){
        service.display();
    }

}
