public class Pickaxe implements Tool {

    @Override
    public void use(Location location, Person person) {
        RockMaterial material = location.mineRandomRock();
        person.addRocks(1, material);
    }
}
