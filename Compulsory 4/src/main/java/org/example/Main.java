package org.example;

import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        // create students
        List<Student> students = Stream.of(
                new Student("S0", Arrays.asList(new Project("P0"), new Project("P1"), new Project("P2"))),
                new Student("S1", Arrays.asList(new Project("P0"), new Project("P1"))),
                new Student("S2", Arrays.asList(new Project("P0")))
        ).collect(Collectors.toCollection(LinkedList::new));

        // print students sorted by name
        Collections.sort(students);
        students.forEach(s -> System.out.println(s.getName()));

        // create projects
        Set<Project> projects = Stream.of(new Project("P0"), new Project("P1"), new Project("P2"))
                .collect(Collectors.toCollection(TreeSet::new));

        // print projects sorted by name
        projects.forEach(p -> System.out.println(p.getName()));
    }

}