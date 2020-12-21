import java.util.Objects;

public class Rock {
    final RockMaterial material;
    final Size size;

    public Rock(RockMaterial material, Size size) {
        this.material = material;
        this.size = size;
    }

    public Boolean isAntilunite() {
        return this.material == RockMaterial.ANTILUNITE;
    }

    @Override
    public String toString() {
        return "Камень с материалом " + material + " и размером " + size + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rock rock = (Rock) o;
        return material == rock.material &&
                size.equals(rock.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, size);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Size size = (Size) o;
            return Double.compare(size.volume, volume) == 0 &&
                    Double.compare(size.density, density) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(volume, density);
        }
    }
}

