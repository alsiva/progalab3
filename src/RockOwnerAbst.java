import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class RockOwnerAbst {
    protected ArrayList<Rock> rocks;

    public RockOwnerAbst(ArrayList<Rock> rocks) {
        this.rocks = rocks;
    }

    public RockOwnerAbst() {
        this.rocks = new ArrayList<>();
    }

    public void addRocks(List<Rock> rocks) {
        this.rocks.addAll(rocks);
    }

    protected List<Rock> removeRock(int amount, RockMaterial material) {
        List<Rock> rocksRemoved = new ArrayList<>();

        Iterator<Rock> iterator = rocks.iterator();

        while (iterator.hasNext() && amount > 0) {
            Rock rock = iterator.next();
            if (rock.material == material) {
                rocksRemoved.add(rock);
                iterator.remove();
                amount--;
            }
        }

        return rocksRemoved;
    }
}
