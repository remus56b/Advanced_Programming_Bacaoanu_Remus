package clase;

import Interface.Node;
import clase.*;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // create a network
        Network network = new Network();

        // create some people and companies
        Person adolf = new Person("Adolf", LocalDate.of(1945, 1, 1));
        Programmer sorin = new Programmer("Sorinel", LocalDate.of(1990, 2, 2), "Java");
        Designer stevan = new Designer("Stevan", LocalDate.of(1995, 3, 3), "Photoshop");
        Company conti = new Company("Continental", "Technology");
        Company vitesco = new Company("Vitesco", "Technology");
        Company netflix = new Company("Netflix", "Entertainment");

        // add nodes to the network
        network.addNode(adolf);
        network.addNode(sorin);
        network.addNode(stevan);
        network.addNode(conti);
        network.addNode(netflix);
        network.addNode(vitesco);

        // add relationships between nodes
        adolf.addRelationship(sorin, "Friend");
        sorin.addRelationship(stevan, "Coworker");
        stevan.addRelationship(conti, "Employer");
        sorin.addRelationship(conti, "Employer");
        conti.addRelationship(vitesco, "Partner");
        vitesco.addRelationship(conti, "Partner");
        adolf.addRelationship(vitesco, "Employer");

        // print out information about nodes
        System.out.println("=== People ===");
        for (Node node : network.getNodes()) {
            if (node instanceof Person) {
                Person person = (Person) node;
                System.out.println(person.getName() + " (" + person.getBirthDate() + ")");
                System.out.println("  Relationships:");
                for (Map.Entry<Node, String> entry : person.getRelationships().entrySet()) {
                    Node otherNode = entry.getKey();
                    String relationshipType = entry.getValue();
                    System.out.println("    " + otherNode.getName() + " (" + relationshipType + ")");
                }
            }
        }

        System.out.println("=== Companies ===");
        for (Node node : network.getNodes()) {
            if (node instanceof Company) {
                Company company = (Company) node;
                System.out.println(company.getName() + " (" + company.getIndustry() + ")");
                System.out.println("  Relationships:");
                for (Map.Entry<Node, String> entry : company.getRelationships().entrySet()) {
                    Node otherNode = entry.getKey();
                    String relationshipType = entry.getValue();
                    System.out.println("    " + otherNode.getName() + " (" + relationshipType + ")");
                }
            }
        }
    }

}
