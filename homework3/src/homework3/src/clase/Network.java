package clase;

import Interface.Node;
import clase.Company;

import java.util.ArrayList;
import java.util.List;

// clase.Network class that contains a List of identifiable nodes
class Network {
    private List<Node> nodes;

    public Network() {
        nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public int getNodeImportance(Node node) {
        int count = 0;
        for (Node otherNode : nodes) {
            if (otherNode == node) {
                continue;
            }
            if (otherNode instanceof Company) {
                Company company = (Company) otherNode;
                if (company.getRelationships().containsKey(node)) {
                    count++;
                }
            } else if (otherNode instanceof Person) {
                Person person = (Person) otherNode;
                if (person.getRelationships().containsKey(node)) {
                    count++;
                }
            }
        }
        return count;
    }
}