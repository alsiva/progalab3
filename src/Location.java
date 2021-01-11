import java.util.*;

public class Location extends RockOwnerAbst {
    private boolean hasGravity = true;
    private final String name;
    private double radiusOfDisabledGravity;

    Location(String name) {
        super(generateRandomRocks());
        this.name = name;
    }

    public void setHasGravity(boolean hasGravity, double radius) {
        this.hasGravity = hasGravity;
        this.radiusOfDisabledGravity = radius;
    }

    public boolean hasGravity() {
        return hasGravity;
    }

    public double getRadiusOfDisabledGravity(){
        return radiusOfDisabledGravity;
    }


    static private ArrayList<Rock> generateRandomRocks() {
        Random random = new Random();
        RockMaterial[] materialsArray = RockMaterial.values();

        ArrayList<Rock> rocks = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            RockMaterial randomMaterial = materialsArray[random.nextInt(materialsArray.length)];
            double randomVolume = random.nextDouble() * 10;
            double randomDensity = random.nextDouble() * 5;
            Rock.Size randomSize = new Rock.Size(randomVolume, randomDensity);
            Rock randomRock = new Rock(randomMaterial, randomSize);
            rocks.add(randomRock);
        }

        return rocks;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
