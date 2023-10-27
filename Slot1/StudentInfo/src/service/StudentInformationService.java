package service;

import model.Student;
import util.Library;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentInformationService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortStudents() {
        Collections.sort(students, new StudentComparator());
    }

    public void displayStudents() {
        int studentNumber = 1;
        for (Student student : students) {
            System.out.println("-------------Student " + studentNumber + "-------------");
            System.out.println(student);
            studentNumber++;
        }
    }

    private class StudentComparator implements java.util.Comparator<Student> {
        public int compare(Student student1, Student student2) {
            return student1.getName().compareTo(student2.getName());
        }
    }
}
