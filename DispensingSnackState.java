public class DispensingSnackState implements StateOfVendingMachine {
    private VendingMachine vendingMachine;

    public DispensingSnackState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void selectSnack(String snackName) {
        System.out.println("Already dispensing a snack.");
    }

    public void insertMoney(double amount) {
        System.out.println("Already dispensing a snack.");
    }

    public void dispenseSnack() {
        Snack selectedSnack = vendingMachine.getSelectedSnack();
        if (selectedSnack.getQuantity() > 0) {
            System.out.println("Dispensing " + selectedSnack.getName());
            selectedSnack.setQuantity(selectedSnack.getQuantity() - 1);
        } else {
            System.out.println(selectedSnack.getName() + " is out of stock.");
        }
        vendingMachine.changeState(new IdleState(vendingMachine));
    }
}
