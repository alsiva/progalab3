import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Location cave = new Location(true);

        Person znayka = new Person("Знайка") {
            private final Pickaxe pickaxe = new Pickaxe();

            @Override
            public Tool getRockMiningTool() {
                return pickaxe;
            }
        };

        Person fuchsia = new PersonWithBareHands("Функсия");
        Person herring = new PersonWithBareHands("Селёдочка");

        znayka.obtainRocks(cave, 4);
        fuchsia.obtainRocks(cave, 10);
        herring.obtainRocks(cave, 10);

        class Team {
            public ZeroGravityDevice craft() throws NoRockOfMaterialException {
                Rock biggestLuniteRock = null;

                for (Person person : Arrays.asList(znayka, fuchsia, herring)) {
                    for (Rock rock : person.rocks) {
                        if (rock.material != RockMaterial.LUNITE) {
                            continue;
                        }
                        if (biggestLuniteRock == null || rock.size.getSize() > biggestLuniteRock.size.getSize()) {
                            biggestLuniteRock = rock;
                        }
                    }
                }

                return new ZeroGravityDevice(biggestLuniteRock, cave);
            }

            public void printTeamState() {
                fuchsia.printGravityState(cave);
                herring.printGravityState(cave);
                znayka.printGravityState(cave);
            }
        }

        Team team = new Team();

        ZeroGravityDevice gravityDevice = null;
        try {
            gravityDevice = team.craft();
            System.out.println("Коротышки сконструировали прибор невесомости");
        } catch (NoRockOfMaterialException e) {
            System.out.println("Коротышки не смогли сконструировать прибор невесомости");
            System.exit(1);
        }

        team.printTeamState();
        try {
            znayka.turnOff(gravityDevice);
        } catch (AlreadyInStateException e) {
            System.out.println("Прибор уже выключен");
        }

        team.printTeamState();

        znayka.say("Нам стоило большого труда отколоть эти камешки от огромнейшей глыбы, найденной в глубине пещеры.");
        znayka.giveRock(2, fuchsia, RockMaterial.ANTILUNITE);
        znayka.giveRock(2, herring, RockMaterial.ANTILUNITE);

        try {
            znayka.turnOn(gravityDevice);
        } catch (AlreadyInStateException e) {
            System.err.println("Прибор уже включен");
        }

        team.printTeamState();
    }
}
