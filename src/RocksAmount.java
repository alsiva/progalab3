import java.util.Objects;

public class RocksAmount extends RocksAbstract {
    RocksAmount(int amount) {
        super(amount);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        RocksAmount that = (RocksAmount) other;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
