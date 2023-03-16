import java.util.HashMap;
import java.util.Map;

class Company implements Comparable<Company>, Node {
    private String name;
    private Map<Person, String> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new HashMap<>();
    }

    public void addEmployee(Person employee, String position) {
        this.employees.put(employee, position);
    }

    public String getPosition(Person employee) {
        return this.employees.get(employee);
    }

    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}