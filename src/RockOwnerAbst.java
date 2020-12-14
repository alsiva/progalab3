import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RockOwnerAbst {
    protected List<Rock> rocks;

    public RockOwnerAbst(List<Rock> rocks) {
        this.rocks = rocks;
    }

    public RockOwnerAbst() {
        this.rocks = new ArrayList<>();
    }

    protected void addRocks(List<Rock> rocks) {
        this.rocks.addAll(rocks);
    }

    protected List<Rock> removeRock(int amount, RockMaterial material) {
        List<Rock> rocks = Collections.emptyList(); // todo: get rock of material

        return rocks;
    }
}
