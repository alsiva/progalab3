public class ZeroGravityDevice implements Toggleable {
    private final Location location;
    private final Position position = new Position(0, 0);
    private final double radius;
    private static final double CAN_TOGGLE_RADIUS = 1;

    ZeroGravityDevice(Rock rock, Location location) {
        if (rock == null || rock.material != RockMaterial.LUNITE) {
            throw new NoRockOfMaterialException(RockMaterial.LUNITE);
        }

        this.location = location;
        this.radius = 5;
        location.setHasGravity(false, radius);
    }

    @Override
    public boolean getIsTurnedOn() {
        return !location.hasGravity();
    }

    @Override
    public void toggle(Person person) {
        if (position.withinDistance(person.getPosition(), CAN_TOGGLE_RADIUS)) {
            if (getIsTurnedOn()) {
                System.out.println(person + " выключает прибор невесомости");
                this.location.setHasGravity(true, radius);
            } else {
                System.out.println(person + " включает переключатель невесомости");
                this.location.setHasGravity(false, radius);
            }
        } else {
            System.out.println(person + " находится слишком далеко от прибора");
        }

    }

    @Override
    public String toString() {
        return "Прибор невесомости";
    }

    public Position getPosition() {
        return position;
    }
}
