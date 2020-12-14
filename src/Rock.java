public class Rock {
    final RockMaterial material;
    final Size size;

    public Rock(RockMaterial material, Size size) {
        this.material = material;
        this.size = size;
    }

    public static class Size {
        final double volume;
        final double density;

        public Size(double volume, double density) {
            this.volume = volume;
            this.density = density;
        }

        public double getSize() {
            return volume * density;
        }
    }
}

