package controller;

import java.util.ArrayList;
import model.Student;
import service.StudentService;
import util.Library;
import view.Menu;

public class StudentManager extends Menu<String> {

    static String[] menuChoice = {"Create", "Find and sort", "Update/Delete", "Report", "Exit"};

    protected Library library;
    protected StudentService service;

    public StudentManager() {
        super("Student Manager", menuChoice);
        library = new Library();
        service = new StudentService();
    }

    @Override
    public boolean execute(int n) {
        switch (n) {
            case 1:
                create();
                break;
            case 2:
                find();
                break;
            case 3:
                updateOrDelete();
                break;
            case 4:
                report();
                break;
            case 5:
                return false;
            default:
                break;
        }
        return true;
    }

    private void create() {
        boolean flat = true;
        do {
            int id = library.getId("Enter Id", n -> !service.exist(n), "Id has exist");
            String name = library.getString("Enter name:");
            int semeter = library.getInt("Enter Semeter");
            String course = choiceCourse();
            if (service.createStudent(new Student(id, name, semeter, course))) {
                String choice = library.getString("DO you want continue (y/n)").trim();
                System.out.println(choice);
                if (choice.equalsIgnoreCase("n")) {
                    flat = false;
                }
            }
        } while (flat);
    }

    private void find() {
        service.sort();
        String name = library.getString("Enter Name Student");
        service.findByName(name).forEach(s -> System.out.println(s));
    }

    private void updateOrDelete() {
        final String[] mcSearch = {"Update", "Delete", "Exit"};
        class SearchMenu extends Menu<String> {

            public SearchMenu() {
                super("", mcSearch);
            }

            @Override
            public boolean execute(int n) {
                int id;
                switch (n) {
                    case 1 -> {
                        id = library.getId("Enter id", (t) -> service.exist(t), "Id not exist");
                        return updateMenu(id);

                    }
                    case 2 -> {
                        id = library.getId("Enter id", (t) -> service.exist(t), "Id not exist");
                        Student s = service.findById(id);
                        System.out.println(s.toString());
                        String check = library.getString("DO you want delete this student (y/n)");
                        if (check.equalsIgnoreCase("y")) {
                            service.delete(id);
                        }else{
                            return false;
                        }
                        
                    }
                    case 3 -> {
                        return false;
                    }
                }
                return true;
            }
        }
        SearchMenu sm = new SearchMenu();
        sm.run();
    }

    private void report() {
        service.report();

    }

    private boolean updateMenu(int id) {
        final String[] mcSearch = {"Name", "Semeter", "Course", "Exit"};
        class SearchMenu extends Menu<String> {

            public SearchMenu() {
                super("", mcSearch);
            }

            @Override
            public boolean execute(int n) {
                switch (n) {
                    case 1 -> {
                        String name = library.getString("Enter new Name");
                        service.updateStudent(id, s -> s.setName(name));
                    }
                    case 2 -> {
                        int semeter = library.getInt("enter new semeter");
                        service.updateStudent(id, s -> s.setSemester(semeter));
                    }
                    case 3 -> {
                        String couString = choiceCourse();
                        service.updateStudent(id, s -> s.setCourse(couString));
                    }
                    case 4 -> {
                        return false;
                    }
                }
                return true;
            }
        }
        SearchMenu sm = new SearchMenu();
        sm.run();
        return false;
    }

    private String choiceCourse() {
        while (true) {
            System.out.println("Couser:");
            System.out.println("1.Java");
            System.out.println("2..Net");
            System.out.println("3.C/C++:");
            int choice = library.getInt("enter your choice");
            switch (choice) {
                case 1:
                    return "Java";
                case 2:
                    return ".Net";

                case 3:
                    return "C/C++";

                default:
                    System.out.println("Wrong!Please enter again");
            }
        }
    }

}
