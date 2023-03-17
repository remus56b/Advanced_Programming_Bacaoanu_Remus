package clase;

import Interface.Node;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a person in a social network.
 */
class Person implements Node, Comparable<Person> {
    private String name;
    private LocalDate birthDate;
    private Map<Node, String> relationships; // map of relationships with other nodes
    /**
     * Creates a new person with the given name and birth date.
     *
     * @param name      the name of the person
     * @param birthDate the birth date of the person
     */
    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        relationships = new HashMap<>();
    }

    /**
     * Adds a relationship from this person to another node.
     *
     * @param node      the node to add a relationship to
     * @param relationshipType  the type of relationship (e.g., friend, coworker)
     */
    public void addRelationship(Node node, String relationshipType) {
        relationships.put(node, relationshipType);
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return name.compareTo(otherPerson.getName());
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}