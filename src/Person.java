import java.util.List;

public class Person extends RockOwnerAbst {
    private final String name;
    private final Location location;

    Person(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public void mineRock(int amount) {
        List<Rock> minedRocks = location.removeRock(amount, RockMaterial.LUNITE);
        addRocks(minedRocks);
    }

    public void giveRock(int amount, Person dude, RockMaterial material) {
        List<Rock> rocks = removeRock(amount, material);
        dude.addRocks(rocks);

        if (amount != rocks.size()) {
            System.out.println(this.name + " не смог дать " + dude.name + " " + amount + " камней типа " + material + ", дал " + rocks.size() + " камней.");
        } else {
            System.out.println(this.name + " дал " + dude.name + " " + amount + " камней типа " + material + ".");
        }
    }

    public void printGravityState() {
        if (location.hasGravity() || hasAntilunite()) {
            System.out.println(this.name + " на земле");
        } else {
            System.out.println(this.name + " в воздухе");
        }
    }

    public void say(String what) {
        System.out.println(what);
    }

    public String getName() {
        return this.name;
    }

    public boolean hasAntilunite() {
        for (Rock rock: this.rocks) {
            if (rock.material == RockMaterial.ANTILUNITE) {
                return true;
            }
        }
        return false;
    }

    public void use(Tool tool) {
        tool.use(this.location, this);
    }
}
