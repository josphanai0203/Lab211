package controller;

import view.Menu;
import service.StudentInformationService;
import model.Student;
import util.Library;

public class StudentController extends Menu {
    private StudentInformationService service;

    public StudentController() {
        this.service = new StudentInformationService();
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = getUserChoice(1, 3);
            switch (choice) {
                case 1:
                    enterStudentInformation();
                    break;
                case 2:
                    service.sortStudents();
                    service.displayStudents();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    private void enterStudentInformation() {
        while (true) {
            String name = getInput("Name: ");
            String classes = getInput("Classes: ");
            float mark = Library.getFloatInput("Mark: ");

            service.addStudent(new Student(name, classes, mark));

            if (!askYesNoQuestion("Do you want to enter more student information? (Y/N): ")) {
                break;
            }
        }
    }
}
