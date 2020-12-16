import java.util.List;

public class Pickaxe implements Tool {
    @Override
    public List<Rock> mineRocks(Location location, int howMuch) {
        return location.removeRock(howMuch, RockMaterial.ANTILUNITE);
    }
}
