public class Main {
    public static void main(String[] args) {
        Road road1 = new Road(Location.Roman, Location.Iasi, 90);
        Road road2 = new Road(Location.Bucuresti, Location.Roman, 365);
        Road road3 = new Road(Location.Roman, Location.Suceava, 130);
        Road road4 = new Road(Location.Roman, Location.Bacau, 70);

        System.out.println(road1);
        System.out.println(road2);
        System.out.println(road3);
        System.out.println(road4);
    }
}
