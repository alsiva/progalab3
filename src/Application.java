import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Location cave = new Location(true);

        Pickaxe pickaxe = new Pickaxe();

        Person znayka = new Person("Знайка", cave) {
            @Override
            public void mineRock(int amount) {
                for (int i = 0; i < amount; i++) {
                    use(pickaxe);
                }
            }
        };

        Person fuchsia = new Person("Функсия", cave);
        Person herring = new Person("Селёдочка", cave);

        // loop here

        znayka.mineRock(4);
        fuchsia.mineRock(10);
        herring.mineRock(10);


        class Team {
            public ZeroGravityDevice craft() throws NoRockOfMaterialException {
                Rock biggestLuniteRock = null;

                for (Person person : Arrays.asList(znayka, fuchsia, herring)) {
                    for (Rock rock : person.rocks) {
                        // todo: compare this rock with the biggest one (also check type)
                    }
                }

                if (biggestLuniteRock == null) {
                    throw new NoRockOfMaterialException(RockMaterial.LUNITE);
                }

                return new ZeroGravityDevice(biggestLuniteRock);
            }
        }

        Team team = new Team();

        ZeroGravityDevice gravityDevice = null;
        try {
            gravityDevice = team.craft();
        } catch (NoRockOfMaterialException e) {
            System.err.println("Коротышки не смогли сделать прибор невесомости");
            System.exit(1);
        }

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
