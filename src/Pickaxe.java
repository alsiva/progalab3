import java.util.List;

public class Pickaxe implements Tool {


    @Override
    public RockMaterial getRockMaterial() {
        return RockMaterial.ANTILUNITE;
    }

    @Override
    public List<Rock> mineRocks(Location location, int howMuch) {
        return location.removeRock(howMuch, RockMaterial.ANTILUNITE);
    }

    @Override
    public String toString() {
        return "Кирка";
    }
}
