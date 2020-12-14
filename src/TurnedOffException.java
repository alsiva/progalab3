public class TurnedOffException extends RuntimeException {
    private final Toggleable toggleable;
    TurnedOffException(Toggleable toggleable) {
        this.toggleable = toggleable;
    }

    @Override
    public String getMessage() {
        return "Прибор не включён: " + toggleable;
    }
}
