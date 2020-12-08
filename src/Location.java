import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Location extends RockOwnerAbst implements LocationActions {
    private boolean isGravityEnabled;

    Location(boolean isGravityEnabled) {
        super(new HashMap<RockMaterial, Integer>() {{
            put(RockMaterial.ANTILUNITE, 50);
            put(RockMaterial.IRON, 70);
            put(RockMaterial.DIAMOND, 20);
        }});

        this.isGravityEnabled = isGravityEnabled;
    }

    public void setGravityEnabled(boolean gravityEnabled) {
        isGravityEnabled = gravityEnabled;
    }

    public boolean getIsGravityEnabled(){
        return isGravityEnabled;
    }

    @Override
    public RockMaterial mineRandomRock() {
        Set<RockMaterial> materialsWeHave = materialToAmount.keySet();
        RockMaterial randomMaterial = new ArrayList<>(materialsWeHave).get(new Random().nextInt(materialsWeHave.size()));

        removeRocks(1, randomMaterial);
        return randomMaterial;
    }

}
