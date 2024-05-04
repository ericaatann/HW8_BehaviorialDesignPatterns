public class IdleState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void selectSnack(String snackName) {
        vendingMachine.setSelectedSnack(snackName);
        vendingMachine.changeState(new WaitingforMoneyState(vendingMachine));
    }

    public void insertMoney(double amount) {
        System.out.println("Please select a snack first.");
    }

    public void dispenseSnack() {
        System.out.println("Please select a snack first.");
    }
}
