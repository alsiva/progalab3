public class NoMoreRocksException extends Exception {
    @Override
    public String getMessage() {
        return "больше нет камней";
    }
}
