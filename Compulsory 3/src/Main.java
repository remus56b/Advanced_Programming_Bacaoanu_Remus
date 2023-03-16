import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Person sorin = new Person("Sorinel");
        Person adolf = new Person("Adolf");
        Person stevan = new Person("Stevan");
        Company conti = new Company("Continental");
        Company bit = new Company("Bitdefender");

        sorin.addFriend(adolf);
        adolf.addFriend(stevan);
        conti.addEmployee(sorin, "Programmer");
        conti.addEmployee(stevan, "Designer");
        bit.addEmployee(adolf, "Manager");

        nodes.add(sorin);
        nodes.add(adolf);
        nodes.add(stevan);
        nodes.add(conti);
        nodes.add(bit);

        Collections.sort(nodes, Comparator.comparing(Node::getName));

        for (Node node : nodes) {
            System.out.println(node.getName());
        }

        System.out.println(stevan.getName() + " is a " + conti.getPosition(stevan) + " at " + conti.getName());
        System.out.println(sorin.getName() + " is a " + conti.getPosition(sorin) + " at " + conti.getName());
        System.out.println(adolf.getName() + " is a " + bit.getPosition(adolf) + " at " + bit.getName());
    }
}