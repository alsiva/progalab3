import java.util.Objects;

public class Location implements LocationActions {
    private boolean isGravityEnabled;
    private final TypeOfLocation place;

    Location(boolean isGravityEnabled, TypeOfLocation place){
        this.isGravityEnabled = isGravityEnabled;
        this.place = place;
    }

    public void setGravityEnabled(boolean gravityEnabled) {
        isGravityEnabled = gravityEnabled;
    }

    public boolean getGravity(){
        return isGravityEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return isGravityEnabled == location.isGravityEnabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isGravityEnabled);
    }
}
