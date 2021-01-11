public class ZeroGravityDevice implements Toggleable {
    private final Location location;
    private double[] position = new double[2];
    private double radius;

    ZeroGravityDevice(Rock rock, Location location) {
        if (rock == null || rock.material != RockMaterial.LUNITE) {
            throw new NoRockOfMaterialException(RockMaterial.LUNITE);
        }

        this.location = location;
        this.position[0] = 0;
        this.position[1] = 0;
        this.radius = 5;
        location.setHasGravity(false, radius);
    }

    @Override
    public boolean getIsTurnedOn() {
        return !location.hasGravity();
    }

    @Override
    public void toggle(Person person) {
        if (Math.pow((person.getPosition()[0] - this.position[0]), 2) + Math.pow((person.getPosition()[1] - this.position[1]), 2) < 1) {
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
}
