package org.example;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        Set<Project> projects = Stream.generate(() -> new Project(faker.color().name() + " Project"))
                .limit(10)
                .collect(Collectors.toCollection(TreeSet::new));

        List<Student> students = Stream.generate(() -> new Student(faker.name().fullName(),
                        Stream.generate(() -> projects).limit(faker.number().numberBetween(1, 5))
                                .flatMap(Collection::stream).collect(Collectors.toSet())))
                .limit(10)
                .collect(Collectors.toList());

        StudentProjectAllocationProblem problem = new StudentProjectAllocationProblem(students, projects);
        System.out.println("Students with few preferences:");
        problem.getStudentsWithFewPreferences().forEach(System.out::println);

        problem.allocateProjects();
        System.out.println("Assigned projects:");
        problem.getStudents().forEach(student -> {
            Project project = student.getAssignedProject();
            System.out.printf("%s - %s%n", student, project);
        });

        // Create the problem instance
        StudentProjectAllocationProblem problem1 = new StudentProjectAllocationProblem();

        // Print out the list of students sorted by name
        System.out.println("Students:");
        problem.getStudents().stream()
                .sorted()
                .forEach(student -> System.out.println(student.getName()));

        // Print out the list of projects sorted by name
        System.out.println("\nProjects:");
        problem.getProjects().stream()
                .sorted()
                .forEach(project -> System.out.println(project.getName()));

        // Solve the problem and print out the allocation
        System.out.println("\nAllocation:");
        problem.allocateProjects();
        problem.printAllocation();
    }
}
