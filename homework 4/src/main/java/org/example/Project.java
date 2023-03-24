package org.example;
import java.util.HashSet;
import java.util.Set;

public class Project implements Comparable<Project> {
    private String name;
    private int capacity;
    private Set<Student> assignedStudents;

    public Project(String name) {
        this.name = name;
        this.capacity = capacity;
        assignedStudents = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void assignStudent(Student student) {
        assignedStudents.add(student);
    }

    public void removeStudent(Student student) {
        assignedStudents.remove(student);
    }

    public Set<Student> getAssignedStudents() {
        return assignedStudents;
    }

    @Override
    public int compareTo(Project o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
