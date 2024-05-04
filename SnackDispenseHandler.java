public abstract class SnackDispenseHandler {
    private SnackDispenseHandler nextHandler;

    public void setNextHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void dispenseSnack(String snackName, double amount) {
        if (canHandle(snackName)) {
            handle(snackName, amount);
        } else if (nextHandler != null) {
            nextHandler.dispenseSnack(snackName, amount);
        } else {
            System.out.println("Snack not available.");
        }
    }

    protected abstract boolean canHandle(String snackName);

    protected abstract void handle(String snackName, double amount);
}
