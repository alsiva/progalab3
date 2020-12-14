public class ZeroGravityDevice implements Toggleable {
    private boolean isTurnedOn = false;
    private final GravityToggle gravityToggle = new GravityToggle();

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
        Boolean isGravityEnabled = true;

        @Override
        public void use(Location location, Person person) {
            if (!isTurnedOn) {
                throw new TurnedOffException(ZeroGravityDevice.this);
            }
            isGravityEnabled = !isGravityEnabled;

            if (isGravityEnabled) {
                System.out.println(person.getName() + " включает переключатель невесомости");
                location.setHasGravity(true);
            } else {
                System.out.println(person.getName() + " выключает прибор невесомости");
                location.setHasGravity(false);
            }
        }
    }
}
