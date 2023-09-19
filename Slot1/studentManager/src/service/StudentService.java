package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import model.Student;

public class StudentService {

    public static ArrayList<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Nguyen Van B", 2, "Java"));
        students.add(new Student(2, "Nguyen Van c", 3, ".Net"));
        students.add(new Student(3, "Nguyen Van A", 2, "Java"));
        students.add(new Student(4, "Nguyen Van A", 2, "Java"));
    }

    public boolean createStudent(Student s) {
        return students.add(s);
    }

    public List<Student> findByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().contains(name)) {
                result.add(s);
            }
        }
        return result;
    }

    public void updateStudent(int id, Consumer<Student> c) {
        for (Student s : students) {
            if (s.getId() == id) {
                c.accept(s);
            }
        }
    }

    public boolean delete(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return students.remove(s);
            }
        }
        return false;
    }

    public void sort() {
        Collections.sort(students, (o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public void report() {
        Map<Student, Integer> reports = new HashMap<>();
        for (Student s : students) {
            Integer value = reports.get(s);
            if (value == null) {
                reports.put(s, 1);

            } else {

                reports.put(s,value+1);
            }
        }
        for(Student s:reports.keySet()){
            System.out.println(s.getName()+"  |  "+s.getCourse()+"  |  "+reports.get(s));
        }
    }

    public boolean exist(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public Student findById(int id){
          for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
          return null;
    }
}
