import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Represents an instance of the problem, consisting of a set of locations and a set of roads connecting them.
 * The problem does not allow adding the same location or road twice.
 */
public class Problem {
    private List<Location> locations;
    private List<Road> roads;

    public Problem() {
        locations = new ArrayList<>();
        roads = new ArrayList<>();
    }
    /**
     * Adds a location to the problem instance if it does not already exist.
     *
     * @param location the location to add
     */
    public void addLocation(Location location) {
        if (!locations.contains(location)) {
            locations.add(location);
        }
    }
    /**
     * Adds a road to the problem instance if it does not already exist.
     *
     * @param road the road to add
     */
    public void addRoad(Road road) {
        if (!roads.contains(road)) {
            roads.add(road);
        }
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Road> getRoads() {
        return roads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Problem)) return false;
        Problem problem = (Problem) o;
        return Objects.equals(locations, problem.locations) && Objects.equals(roads, problem.roads);
    }

    /**
     * A problem instance is valid if it has at least two locations and one road.
     */
    public boolean isValid() {
        // A problem instance is valid if it has at least two locations and one road.
        return locations.size() >= 2 && roads.size() >= 1;
    }
    /**
     * Determines if it is possible to go from one location to another using the given roads.
     *
     * @param from the starting location
     * @param to   the destination location
     * @return true
     * if there exists a path from 'from' to 'to', false otherwise
     */
    public boolean canReach(Location from, Location to) {
        // We can use a recursive depth-first search to check if we can reach the destination location from the source location.
        return canReach(from, to, new ArrayList<>());
    }

    private boolean canReach(Location from, Location to, List<Location> visited) {
        if (visited.contains(from)) {
            // We have already visited this location, so we can't reach the destination from here.
            return false;
        }
        if (from.equals(to)) {
            // We have reached the destination!
            return true;
        }
        visited.add(from);
        for (Road road : roads) {
            if (road.getStart().equals(from) && canReach(road.getEnd(), to, visited)) {
                // We can reach the destination from the end of this road.
                return true;
            }
        }
        // We can't reach the destination from here.
        return false;
    }
}