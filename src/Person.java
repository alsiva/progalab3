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
            System.out.println(this.name + " не смог дать " + amount + ", дал "+amountWeHave);
        } else {
            System.out.println(this.name + " дал " + amount);
        }
    }

    public void getState() {
        if (location.getIsGravityEnabled() || hasEnoughAntilunite(1)) {
            System.out.println(this.name + " находится на земле");
        } else {
            System.out.println(this.name + " находится в воздухе");
        }
    }

    public void say(String what) {
        System.out.println(what);
    }

    public void toggleState(GravityDevice gravityDevice) {
        gravityDevice.changeState(location, name);
    }

    public void mineRock(Location place) {
        RockMaterial material = place.mineRandomRock();
        addRocks(1, material);
    }

    public boolean hasEnoughAntilunite(int enough) {
        return this.materialToAmount.getOrDefault(RockMaterial.ANTILUNITE, 0) >= enough;
    }
}
