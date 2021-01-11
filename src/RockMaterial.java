public enum RockMaterial {
    LUNITE("Лунит", 2, 10, "ТёмноФиолетовый"),
    ANTILUNITE("Антилунит", 3, 15, "ЯркоФиолетовый");

    private final String name;
    private final int roughness;
    private final int density;
    private final String color;

    RockMaterial(String name, int roughness, int density, String color) {
        this.name = name;
        this.roughness = roughness;
        this.density = density;
        this.color = color;
    }

    public int getRoughness() {
        return roughness;
    }

    @Override
    public String toString() {
        return name;
    }
}
