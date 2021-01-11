import java.util.List;

abstract public class Person extends RockOwnerAbst {
    private final String name;
    private double[] position = new double[2];

    Person(String name, double x, double y) {
        this.name = name;
        this.position[0] = x;
        this.position[1] = x;
    }

    public double[] getPosition(){
        return position;
    }

    public void move(double x, double y) {
        this.position[0] = x;
        this.position[1] = y;
        System.out.print(Person.this + "переместился на координаты" + "x = " + x + " y = "+ y);
    }

    abstract public Tool getRockMiningTool();

    public void obtainRocks(Location location, int amount) {
        Tool tool = getRockMiningTool();
        List<Rock> rocks = tool.mineRocks(location, amount);
        System.out.println(Person.this + " добыл из " + location + " " + amount + " камней " + " вида " + tool.getRockMaterial());
        addRocks(rocks);
    }

    public void giveRock(int amount, RockOwnerAbst dude, RockMaterial material) {
        List<Rock> rocks = removeRock(amount, material);
        dude.addRocks(rocks);

        if (amount != rocks.size()) {
            System.out.println(this + " не смог дать " + dude + " " + amount + " камней типа " + material + ", дал " + rocks.size() + " камней.");
        } else {
            System.out.println(this + " дал " + dude + " " + amount + " камней типа " + material + ".");
        }
    }

    public void printGravityState(Location location) {
        if (location.hasGravity() || this.hasAntilunite() || ((Math.pow(this.position[0], 2) + (Math.pow(this.position[1], 2)) < Math.pow(location.getRadiusOfDisabledGravity(), 2)))) {
            System.out.println(this + " на земле");
        } else {
            System.out.println(this + " в воздухе");
        }
    }

    public void say(String what) {
        System.out.println(what);
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

        public RockMaterial getRockMaterial() {
            return RockMaterial.LUNITE;
        }

        @Override
        public List<Rock> mineRocks(Location location, int howMuch) {
            return location.removeRock(howMuch, RockMaterial.LUNITE);
        }

        @Override
        public String toString() {
            return "Голые руки у " + Person.this;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
