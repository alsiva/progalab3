public class NoRockOfMaterialException extends RuntimeException {
    private final RockMaterial material;

    public NoRockOfMaterialException(RockMaterial material) {
        this.material = material;
    }

    @Override
    public String getMessage() {
        return "Больше нет камней с материалом " + material;
    }
}
