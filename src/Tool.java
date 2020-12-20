import java.util.List;

public interface Tool {
    RockMaterial getRockMaterial();
    List<Rock> mineRocks(Location location, int howMuch);
}
