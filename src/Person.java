import java.util.List;

abstract public class Person extends RockOwnerAbst {
    private final String name;

    Person(String name) {
        this.name = name;
    }

    abstract public Tool getRockMiningTool();

    public void obtainRocks(Location location, int amount) {
        Tool tool = getRockMiningTool();
        List<Rock> rocks = tool.mineRocks(location, amount);

        addRocks(rocks);
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

    public void printGravityState(Location location) {
        if (location.hasGravity() || this.hasAntilunite()) {
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

    public void turnOn(Toggleable toggleable) throws AlreadyInStateException {
        if (toggleable.getIsTurnedOn()) {
            throw new AlreadyInStateException(toggleable);
        }

        toggleable.toggle(this);
    }
    public void turnOff(Toggleable toggleable) throws AlreadyInStateException {
        if (!toggleable.getIsTurnedOn()) {
            throw new AlreadyInStateException(toggleable);
        }

        toggleable.toggle(this);
    }

    class BareHands implements Tool {
        @Override
        public List<Rock> mineRocks(Location location, int howMuch) {
            System.out.println(getName() + " добыл из " + location + " " + howMuch + " камней вида " + RockMaterial.LUNITE);
            return location.removeRock(1, RockMaterial.LUNITE);
        }
    }
}
