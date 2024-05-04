public class KitKatHandler extends SnackDispenseHandler {
    private VendingMachine vendingMachine;

    public KitKatHandler(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    protected boolean canHandle(String snackName) {
        return snackName.equals("KitKat");
    }

    protected void handle(String snackName, double amount) {
        Snack kitKat = vendingMachine.getSnack("KitKat");
        if (kitKat.getQuantity() > 0 && amount >= kitKat.getPrice()) {
            vendingMachine.setSelectedSnack("KitKat");
            vendingMachine.insertMoney(amount);
            vendingMachine.dispenseSnack();
        } else {
            System.out.println("KitKat not available or insufficient funds.");
        }
    }
}
