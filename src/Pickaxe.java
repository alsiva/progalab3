public class Pickaxe implements Tool {

    @Override
    public void use(Location location, Person person) {
        try {
            RockMaterial material = location.mineRandomRock();
            person.addRocks(1, material);
        } catch (NoMoreRocksException e) {
            System.err.println("В пещере закончились камни");

            System.exit(1);
        }
    }
}
