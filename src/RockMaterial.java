public enum RockMaterial {
    IRON("Железо"),
    DIAMOND("Алмаз"),
    LUNITE("Лунит"),
    ANTILUNITE("Антилунит");

    private final String name;

    RockMaterial(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
