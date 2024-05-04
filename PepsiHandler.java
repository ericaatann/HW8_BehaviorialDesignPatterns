public class PepsiHandler extends SnackDispenseHandler {
    private VendingMachine vendingMachine;

    public PepsiHandler(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    protected boolean canHandle(String snackName) {
        return snackName.equals("Pepsi");
    }

    protected void handle(String snackName, double amount) {
        Snack pepsi = vendingMachine.getSnack("Pepsi");
        if (pepsi.getQuantity() > 0 && amount >= pepsi.getPrice()) {
            vendingMachine.setSelectedSnack("Pepsi");
            vendingMachine.insertMoney(amount);
            vendingMachine.dispenseSnack();
        } else {
            System.out.println("Pepsi not available or insufficient funds.");
        }
    }
}
