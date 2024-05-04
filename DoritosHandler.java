public class DoritosHandler extends SnackDispenseHandler {
    private VendingMachine vendingMachine;

    public DoritosHandler(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    protected boolean canHandle(String snackName) {
        return snackName.equals("Doritos");
    }

    protected void handle(String snackName, double amount) {
        Snack doritos = vendingMachine.getSnack("Doritos");
        if (doritos.getQuantity() > 0 && amount >= doritos.getPrice()) {
            vendingMachine.setSelectedSnack("Doritos");
            vendingMachine.insertMoney(amount);
            vendingMachine.dispenseSnack();
        } else {
            System.out.println("Doritos not available or insufficient funds.");
        }
    }
}
