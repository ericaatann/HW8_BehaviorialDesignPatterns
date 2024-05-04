public class SnickersHandler extends SnackDispenseHandler {
    private VendingMachine vendingMachine;

    public SnickersHandler(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    protected boolean canHandle(String snackName) {
        return snackName.equals("Snickers");
    }

    protected void handle(String snackName, double amount) {
        Snack snickers = vendingMachine.getSnack("Snickers");
        if (snickers.getQuantity() > 0 && amount >= snickers.getPrice()) {
            vendingMachine.setSelectedSnack("Snickers");
            vendingMachine.insertMoney(amount);
            vendingMachine.dispenseSnack();
        } else {
            System.out.println("Snickers not available or insufficient funds.");
        }
    }
}
