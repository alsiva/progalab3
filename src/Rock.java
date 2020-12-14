public class Rock {
    final RockMaterial material;
    final Size size;

    public Rock(RockMaterial material, Size size) {
        this.material = material;
        this.size = size;
    }

    public static class Size {
        double volume;
        double density;

        public double getSize() {
            return volume * density;
        }
    }
}

