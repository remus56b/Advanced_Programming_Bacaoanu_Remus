package org.example;
import java.util.HashSet;
import java.util.Set;

public class Student implements Comparable<Student> {
    private String name;
    private Set<Project> admissibleProjects;
    private Project assignedProject;

    public Student(String name, Set<Project> admissibleProjects) {
        this.name = name;
        this.admissibleProjects = admissibleProjects;
        this.assignedProject = null;
    }

    public String getName() {
        return name;
    }

    public Set<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    public Project getAssignedProject() {
        return assignedProject;
    }

    public void assignProject(Project project) {
        this.assignedProject = project;
    }

    public boolean isAssigned() {
        return assignedProject != null;
    }

    public boolean prefers(Project project) {
        return admissibleProjects.contains(project);
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", admissibleProjects=" + admissibleProjects +
                ", assignedProject=" + assignedProject +
                '}';
    }
}


