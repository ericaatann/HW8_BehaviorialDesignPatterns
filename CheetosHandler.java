public class CheetosHandler extends SnackDispenseHandler {
    private VendingMachine vendingMachine;

    public CheetosHandler(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    protected boolean canHandle(String snackName) {
        return snackName.equals("Cheetos");
    }

    protected void handle(String snackName, double amount) {
        Snack cheetos = vendingMachine.getSnack("Cheetos");
        if (cheetos.getQuantity() > 0 && amount >= cheetos.getPrice()) {
            vendingMachine.setSelectedSnack("Cheetos");
            vendingMachine.insertMoney(amount);
            vendingMachine.dispenseSnack();
        } else {
            System.out.println("Cheetos not available or insufficient funds.");
        }
    }
}
