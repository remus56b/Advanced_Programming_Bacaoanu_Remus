public class Road {
    private Location startLocation;
    private Location endLocation;
    private int distance;

    public Road(Location startLocation, Location endLocation, int distance) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Road{" +
                "startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                ", distance=" + distance +
                '}';
    }
}