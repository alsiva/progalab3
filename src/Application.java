public class Application {
    public static void main(String[] args) {
        Location cave = new Location(true, TypeOfLocation.cave);

        Person znayka = new Person("Знайка", new RocksAmount(10), cave);
        Person scout = new Person("Scout", new RocksAmount(10), cave);
        Person heavy = new Person("Heavy", new RocksAmount(10), cave);

        znayka.giveRock(5, scout);
        znayka.giveRock(5, heavy);

        znayka.disableGravity();

        znayka.getState();

        //Person znaykaClone = new Person("Знайка", new RocksAmount(0), cave);

        //System.out.println(znayka.equals(znaykaClone));
        //System.out.println(znayka);
    }
}
