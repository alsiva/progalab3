public class Pickaxe implements Tool {
    @Override
    public void use(Location location, Person person) {
        person.addRocks(location.removeRock(1, RockMaterial.ANTILUNITE));
    }
}
