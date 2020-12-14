import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Location extends RockOwnerAbst {
    private boolean hasGravity;

    Location(boolean isGravityEnabled) {
        super(new HashMap<RockMaterial, Integer>() {{
                put(RockMaterial.ANTILUNITE, 50);
                put(RockMaterial.IRON, 70);
                put(RockMaterial.DIAMOND, 20);
            }
        });

        this.hasGravity = isGravityEnabled;
    }

    public void setHasGravity(boolean hasGravity) {
        this.hasGravity = hasGravity;
    }

    public boolean hasGravity() {
        return hasGravity;
    }

    public RockMaterial mineRandomRock() throws NoMoreRocksException {
        Set<RockMaterial> materialsWeHave = materialToAmount.keySet();

        if (materialsWeHave.size() == 0) {
            throw new NoMoreRocksException();
        }

        RockMaterial randomMaterial = new ArrayList<>(materialsWeHave).get(new Random().nextInt(materialsWeHave.size()));
        removeRocks(1, randomMaterial);
        return randomMaterial;
    }

}
