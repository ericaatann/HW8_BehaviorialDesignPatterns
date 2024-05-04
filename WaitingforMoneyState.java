public class WaitingforMoneyState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public WaitingforMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void selectSnack(String snackName) {
        System.out.println("Already waiting for money.");
    }

    public void insertMoney(double amount) {
        double price = vendingMachine.getSelectedSnack().getPrice();
        if (amount >= price) {
            vendingMachine.changeState(new DispensingSnackState(vendingMachine));
        } else {
            System.out.println("Insufficient money. Please insert more.");
        }
    }

    public void dispenseSnack() {
        System.out.println("Please insert money first.");
    }
}
