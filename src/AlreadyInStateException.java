public class AlreadyInStateException extends Exception {
    private final Toggleable toggleable;

    AlreadyInStateException(Toggleable toggleable) {
        this.toggleable = toggleable;
    }

    @Override
    public String getMessage() {
        return toggleable + " уже был " + (toggleable.getIsTurnedOn() ? "включен" : "выключен");
    }
}
