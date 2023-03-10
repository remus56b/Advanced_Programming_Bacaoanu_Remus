public class Main {
    public static void main(String[] args) {
        Location iasi = new Location("Iasi");
        Location bucuresti = new Location("Bucuresti");
        Location cluj = new Location("Cluj");
        Road iasiBucuresti = new Road(iasi, bucuresti);
        Road bucurestiCluj = new Road(bucuresti, cluj);
        Problem problem = new Problem();
        problem.addLocation(iasi);
        problem.addLocation(bucuresti);
        problem.addLocation(cluj);
        problem.addRoad(iasiBucuresti);
        problem.addRoad(bucurestiCluj);
        System.out.println(problem.getLocations());
        System.out.println(problem.getRoads());
        System.out.println("problema este valida? : " + problem.isValid());
        System.out.println(problem.canReach(iasi, cluj));
        System.out.println(problem.canReach(cluj, iasi));
    }
}