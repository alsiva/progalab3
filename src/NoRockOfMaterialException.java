public class NoRockOfMaterialException extends Exception {
    private final RockMaterial material;

    public NoRockOfMaterialException(RockMaterial material) {
        this.material = material;
    }

    @Override
    public String getMessage() {
        return "больше нет камней с материалом " + material;
    }
}
