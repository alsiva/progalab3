public class Application {
    public static void main(String[] args) {
        GravityDevice gravityDevice = new GravityDevice();
        Location cave = new Location(true);

        Person znayka = new Person("Знайка", cave);
        Person scout = new Person("Scout", cave);
        Person heavy = new Person("Heavy", cave);

        while (!znayka.hasEnoughAntilunite(10)) {
            znayka.mineRock(cave);
        }

        znayka.say("");

        znayka.giveRock(5, scout, RockMaterial.ANTILUNITE);
        znayka.giveRock(5, heavy, RockMaterial.ANTILUNITE);

        znayka.toggleState(gravityDevice);

        znayka.getState();
    }
}
