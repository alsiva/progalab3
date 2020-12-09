public class Application {
    public static void main(String[] args) {
        ZeroGravityDevice gravityDevice = new ZeroGravityDevice();
        Location cave = new Location(true);

        Person znayka = new Person("Знайка", cave);
        Person scout = new Person("Scout", cave);
        Person heavy = new Person("Heavy", cave);

        Pickaxe pickaxe = new Pickaxe();

        while (!znayka.hasEnoughAntilunite(10)) {
            znayka.use(pickaxe);
        }

        znayka.say("Нам стоило большого труда отколоть эти камешки от огромнейшей глыбы, найденной в глубине пещеры.");

        znayka.giveRock(5, scout, RockMaterial.ANTILUNITE);
        znayka.giveRock(5, heavy, RockMaterial.ANTILUNITE);

        znayka.turnOn(gravityDevice);
        znayka.use(gravityDevice.getGravityToggle());

        scout.getGravityState();
        heavy.getGravityState();
        znayka.getGravityState();
    }
}
