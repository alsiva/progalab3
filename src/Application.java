public class Application {
    public static void main(String[] args) {
        Location cave = new Location(true);

        Person znayka = new Person("Знайка", cave);
        Pickaxe pickaxe = new Pickaxe();

        while (!znayka.hasEnoughAntilunite(10)) {
            znayka.use(pickaxe);
        }



        Person fuchsia = new Person("Функсия", cave);
        Person herring = new Person("Селёдочка", cave);

        class Team {
            public ZeroGravityDevice craft() {

            }
        }

        Team team = new Team();

        ZeroGravityDevice gravityDevice = team.craft();
        //

        znayka.say("Нам стоило большого труда отколоть эти камешки от огромнейшей глыбы, найденной в глубине пещеры.");

        znayka.giveRock(5, fuchsia, RockMaterial.ANTILUNITE);
        znayka.giveRock(5, herring, RockMaterial.ANTILUNITE);

        znayka.turnOn(gravityDevice);
        znayka.use(gravityDevice.getGravityToggle());

        fuchsia.getGravityState();
        herring.getGravityState();
        znayka.getGravityState();
    }
}
