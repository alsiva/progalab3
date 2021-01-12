public enum RockMaterial {
    LUNITE("Лунит", 2),
    ANTILUNITE("Антилунит", 3);

    private final String name;
    private final int roughness;

    RockMaterial(String name, int roughness) {
        this.name = name;
        this.roughness = roughness;
    }

    public int getRoughness() {
        return roughness;
    }

    @Override
    public String toString() {
        return name;
    }
}
