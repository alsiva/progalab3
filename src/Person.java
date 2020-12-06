import java.util.Objects;

public class Person implements Actions {
    private final String name;
    private final RocksAmount rocks;
    private final Location location;

    Person(String name, RocksAmount rocks, Location location){
        this.name = name;
        this.rocks = rocks;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\'' +
                ", rocks=" + rocks.getRocks() +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Person person = (Person) other;

        return name.equals(person.name) &&
                rocks.equals(person.rocks) &&
                location.equals(person.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rocks, location);
    }

    public void giveRock(int n, Person dude) {
        if (this.rocks.getRocks() - n >= 0) {
            dude.rocks.setRocks(dude.rocks.getRocks() + n);
            this.rocks.setRocks(this.rocks.getRocks() - n);
            System.out.println(this.name + " даёт " + dude.name + " " + n + " камней");
        }
        else {
            System.out.println(this.name + " не может дать " + dude.name + " " + n + " камней");
        }
    }

    public void disableGravity() {
        System.out.println(this.name + " отключает гравитацию");
        location.setGravityEnabled(false);
    }

    public void getState() {
        if (location.getGravity()) {
            System.out.println(this.name+ " находится на земле");
        }
        if (this.rocks.getRocks() > 0) {
            System.out.println(this.name+ " находится на земле");
        } else {
            System.out.println(this.name+ " находится в воздухе");
        }
    }
}
