public class PersonWithBareHands extends Person {
    private final Tool bareHands = new BareHands();

    PersonWithBareHands(String name, double x, double y) {
        super(name,  x,  y);
    }

    @Override
    public Tool getRockMiningTool() {
        return bareHands;
    }
}
