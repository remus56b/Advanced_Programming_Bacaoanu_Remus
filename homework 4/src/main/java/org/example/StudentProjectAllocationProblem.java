package org.example;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentProjectAllocationProblem {
    private List<Student> students;
    private Set<Project> projects;

    public StudentProjectAllocationProblem(List<Student> students, Set<Project> projects) {
        this.students = students;
        this.projects = projects;
    }

    public StudentProjectAllocationProblem() {

    }

    public Set<Project> getProjects() {
        return projects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> getStudentsWithFewPreferences() {
        double avgPreferences = students.stream()
                .mapToInt(s -> s.getAdmissibleProjects().size())
                .average()
                .orElse(0.0);

        return students.stream()
                .filter(s -> s.getAdmissibleProjects().size() < avgPreferences)
                .sorted()
                .collect(Collectors.toList());
    }

    public void allocateProjects() {
        for (Project project : projects) {
            List<Student> preferences = students.stream()
                    .filter(s -> s.prefers(project))
                    .sorted(Comparator.comparingInt(s -> s.getAdmissibleProjects().size()))
                    .collect(Collectors.toList());

            for (Student student : preferences) {
                if (!student.isAssigned()) {
                    student.assignProject(project);
                    project.assignStudent(student);
                    break;
                } else {
                    Project currentProject = student.getAssignedProject();
                    if (project.getCapacity() > currentProject.getCapacity() && student.prefers(project)) {
                        currentProject.removeStudent(student);
                        student.assignProject(project);
                        project.assignStudent(student);
                        break;
                    }
                }
            }
        }
    }


    public void printAllocation() {
        for (Project project : projects) {
            System.out.println("Project: " + project.getName());
            System.out.println("Capacity: " + project.getCapacity());
            System.out.println("Assigned students: " + project.getAssignedStudents().stream()
                    .map(Student::getName)
                    .collect(Collectors.joining(", ")));
            System.out.println();
        }
    }

}
