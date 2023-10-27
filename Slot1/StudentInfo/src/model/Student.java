package model;

public class Student {
    private String name;
    private float mark;
    private String classes;

    public Student(String name, String classes, float mark) {
        this.name = name;
        this.classes = classes;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public float getMark() {
        return mark;
    }

    public String getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return "-------------Student-------------\n" +
               "Name: " + name + "\n" +
               "Classes: " + classes + "\n" +
               "Mark: " + mark;
    }
}
