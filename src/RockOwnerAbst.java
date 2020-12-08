import java.util.HashMap;
import java.util.Map;

public abstract class RockOwnerAbst {
    protected final Map<RockMaterial, Integer> materialToAmount;

    public RockOwnerAbst(Map<RockMaterial, Integer> materialToAmount) {
        this.materialToAmount = materialToAmount;
    }

    public RockOwnerAbst() {
        this.materialToAmount = new HashMap<>();
    }

    protected void addRocks(int amount, RockMaterial material) {
        Integer storageAmount = materialToAmount.getOrDefault(material, 0);
        materialToAmount.put(material,storageAmount + amount);
    }

    protected int removeRocks(int amount, RockMaterial material) {
        Integer storageAmount = materialToAmount.get(material);
        if (storageAmount > amount) {
            materialToAmount.put(material, storageAmount - amount);
            return amount;
        } else {
            materialToAmount.remove(material);
            return storageAmount;
        }
    }
}
