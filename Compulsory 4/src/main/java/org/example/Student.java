package org.example;
import java.util.List;

public class Student implements Comparable<Student> {

    private String name;
    private List<Project> admissibleProjects;

    public Student(String name, List<Project> admissibleProjects) {
        this.name = name;
        this.admissibleProjects = admissibleProjects;
    }

    public String getName() {
        return name;
    }

    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    @Override
    public int compareTo(Student other) {
        return name.compareTo(other.getName());
    }

}
