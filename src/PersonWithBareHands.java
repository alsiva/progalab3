public class PersonWithBareHands extends Person {
    private final Tool bareHands = new BareHands();

    PersonWithBareHands(String name) {
        super(name);
    }

    @Override
    public Tool getRockMiningTool() {
        return bareHands;
    }
}
