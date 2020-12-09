public class Person extends RockOwnerAbst {
    private final String name;
    private final Location location;

    Person(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public void receiveRocks(int amount, RockMaterial material) {
        this.addRocks(amount, material);
    }

    public void giveRock(int amount, Person dude, RockMaterial material) {
        int amountWeHave = removeRocks(amount, material);
        dude.receiveRocks(amountWeHave, material);

        if (amount != amountWeHave) {
            System.out.println(this.name + " не смог дать " + amount + ", дал " + amountWeHave);
        } else {
            System.out.println(this.name + " дал " + amount);
        }
    }

    public void getGravityState() {
        if (location.hasGravity() || hasEnoughAntilunite(1)) {
            System.out.println(this.name + " находится на земле");
        } else {
            System.out.println(this.name + " находится в воздухе");
        }
    }

    public void say(String what) {
        System.out.println(what);
    }

    public String getName() {
        return this.name;
    }

    public boolean hasEnoughAntilunite(int enough) {
        return this.materialToAmount.getOrDefault(RockMaterial.ANTILUNITE, 0) >= enough;
    }

    public void turnOn(Toggleable toggleable) {
        if (toggleable.getIsTurnedOn()) {
            System.out.println("Прибор уже включён");
        } else {
            toggleable.toggle();
            System.out.println(this.name + " включил прибор");
        }
    }

    public void use(Tool tool) {
        tool.use(this.location, this);
    }
}
