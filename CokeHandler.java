public class CokeHandler extends SnackDispenseHandler {
    private VendingMachine vendingMachine;

    public CokeHandler(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    protected boolean canHandle(String snackName) {
        return snackName.equals("Coke");
    }

    protected void handle(String snackName, double amount) {
        Snack coke = vendingMachine.getSnack("Coke");
        if (coke.getQuantity() > 0 && amount >= coke.getPrice()) {
            vendingMachine.setSelectedSnack("Coke");
            vendingMachine.insertMoney(amount);
            vendingMachine.dispenseSnack();
        } else {
            System.out.println("Coke not available or insufficient funds.");
        }
    }
}
