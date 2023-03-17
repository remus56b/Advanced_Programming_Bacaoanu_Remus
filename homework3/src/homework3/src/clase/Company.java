package clase;

import Interface.Node;

import java.util.HashMap;
import java.util.Map;

// clase.Company class that implements the Interface.Node interface and Comparable interface
class Company implements Node, Comparable<Company> {
    private String name;
    private Map<Node, String> relationships; // map of relationships with other nodes
    private String industry; // specific property for clase.Company class

    public Company(String name, String industry) {
        this.name = name;
        this.industry = industry;
        relationships = new HashMap<>();
    }

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
    public int compareTo(Company otherCompany) {
        return name.compareTo(otherCompany.getName());
    }

    public String getIndustry() {
        return industry;
    }
}