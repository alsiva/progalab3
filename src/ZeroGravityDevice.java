public class ZeroGravityDevice implements Toggleable {
    private boolean isTurnedOn = true;
    private final GravityToggle gravityToggle = new GravityToggle();

    ZeroGravityDevice(Rock rock, Location location) throws NoRockOfMaterialException {
        if (rock == null || rock.material != RockMaterial.LUNITE) {
            throw new NoRockOfMaterialException(RockMaterial.LUNITE);
        }

        location.setHasGravity(false);
    }

    @Override
    public boolean getIsTurnedOn() {
        return isTurnedOn;
    }

    @Override
    public void toggle() {
        isTurnedOn = !isTurnedOn;
    }

    public GravityToggle getGravityToggle() {
        return gravityToggle;
    }

    class GravityToggle implements Tool {
        @Override
        public void use(Location location, Person person) {
            if (isTurnedOn) {
                System.out.println(person.getName() + " выключает прибор невесомости");
                location.setHasGravity(true);
            } else {
                System.out.println(person.getName() + " включает переключатель невесомости");
                location.setHasGravity(false);
            }
            toggle();
        }
    }
}
