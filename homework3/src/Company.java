import java.util.HashMap;
import java.util.Map;

// Company class that implements the Node interface and Comparable interface
class Company implements Node, Comparable<Company> {
    private String name;
    private Map<Node, String> relationships; // map of relationships with other nodes
    private String industry; // specific property for Company class

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