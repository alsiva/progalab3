public class ZeroGravityDevice implements Toggleable {
    private final Location location;

    ZeroGravityDevice(Rock rock, Location location) {
        if (rock == null || rock.material != RockMaterial.LUNITE) {
            throw new NoRockOfMaterialException(RockMaterial.LUNITE);
        }

        this.location = location;
        location.setHasGravity(false);
    }

    @Override
    public boolean getIsTurnedOn() {
        return !location.hasGravity();
    }

    @Override
    public void toggle(Person person) {
        if (getIsTurnedOn()) {
            System.out.println(person.getName() + " выключает прибор невесомости");
            this.location.setHasGravity(true);
        } else {
            System.out.println(person.getName() + " включает переключатель невесомости");
            this.location.setHasGravity(false);
        }
    }
}
