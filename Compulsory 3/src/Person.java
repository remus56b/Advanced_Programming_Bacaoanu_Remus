import java.util.ArrayList;
import java.util.List;

class Person implements Comparable<Person>, Node {
    private String name;
    private List<Person> friends;

    public Person(String name) {
        this.name = name;
        this.friends = new ArrayList<>();
    }

    public void addFriend(Person friend) {
        this.friends.add(friend);
        friend.friends.add(this);
    }

    public List<Person> getFriends() {
        return this.friends;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}