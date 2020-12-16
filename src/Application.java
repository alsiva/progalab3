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
                fuchsia.printGravityState();
                herring.printGravityState();
                znayka.printGravityState();
            }
        }

        Team team = new Team();

        ZeroGravityDevice gravityDevice = null;
        try {
            gravityDevice = team.craft();
            System.out.println("Коротышки сконструировали прибор невесомости");
        } catch (NoRockOfMaterialException e) {
            System.err.println("Коротышки не смогли сконструировать прибор невесомости");
            System.exit(1);
        }

        team.printTeamState();
        znayka.use(gravityDevice.getGravityToggle());
        team.printTeamState();

        znayka.say("Нам стоило большого труда отколоть эти камешки от огромнейшей глыбы, найденной в глубине пещеры.");
        znayka.giveRock(2, fuchsia, RockMaterial.ANTILUNITE);
        znayka.giveRock(2, herring, RockMaterial.ANTILUNITE);

        znayka.use(gravityDevice.getGravityToggle());

        team.printTeamState();

    }
}
