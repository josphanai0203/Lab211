package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import model.History;
import model.Worker;

public class WorkerManagerService {

    public static ArrayList<Worker> workers = new ArrayList<>();
    public static ArrayList<History> historys = new ArrayList<>();
    public static int index = 1;

    static {
       
    }

    public boolean create(String id, String name, int age, int salary, String workLocation) {
        return workers.add(new Worker(id, name, age, salary, workLocation));
    }
    public void upSalary(String id, int newSalary) {
        Worker w = findById(id);
        w.setSalary(newSalary);
        historys.add(new History("UP", getCurrentDate(), w.getId(),
                w.getName(), w.getAge(), newSalary,
                w.getWorkLocation()));
    }
    public void downSalary(String id, int newSalary) {
        Worker w = findById(id);
        w.setSalary(newSalary);
        historys.add(new History("DOWN", getCurrentDate(), w.getId(),
                w.getName(), w.getAge(), newSalary,
                w.getWorkLocation()));
    }

    public Worker findById(String id) {
        for (Worker c : workers) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public boolean exist(String id) {
        if(workers.isEmpty()){
            return false;
        }else{
        for (Worker w : workers) {
            if (w.getId().equals(id)) {
                return true;
            }
        }
        return false;
            
        }
    }

    public void printHistory(History history) {
       
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }
    public void display(){
         System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
         for(History h:historys){
             printHistory(h);
         }
    }
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
