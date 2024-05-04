import java.util.List;
import java.util.ArrayList;

public class VendingMachine implements StateOfVendingMachine {
    private StateOfVendingMachine currentState;
    private List<Snack> snacks;
    private String selectedSnack;

    public VendingMachine() {
        currentState = new IdleState(this);
        snacks = new ArrayList<>();
        selectedSnack = null;
    }

    public void addSnack(Snack snack) {
        snacks.add(snack);
    }

    public Snack getSnack(String snackName) {
        for (Snack snack : snacks) {
            if (snack.getName().equals(snackName)) {
                return snack;
            }
        }
        return null;
    }

    public void setSelectedSnack(String selectedSnack) {
        this.selectedSnack = selectedSnack;
    }

    public Snack getSelectedSnack() {
        return getSnack(selectedSnack);
    }

    public void changeState(StateOfVendingMachine newState) {
        currentState = newState;
    }

    public void selectSnack(String snackName) {
        currentState.selectSnack(snackName);
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(amount);
    }

    public void dispenseSnack() {
        currentState.dispenseSnack();
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.addSnack(new Snack("Coke", 1.5, 10));
        vendingMachine.addSnack(new Snack("Pepsi", 1.5, 10));
        vendingMachine.addSnack(new Snack("Cheetos", 1.0, 5));
        vendingMachine.addSnack(new Snack("Doritos", 1.2, 8));
        vendingMachine.addSnack(new Snack("KitKat", 0.8, 15));
        vendingMachine.addSnack(new Snack("Snickers", 0.9, 1));

        SnackDispenseHandler cokeHandler = new CokeHandler(vendingMachine);
        SnackDispenseHandler pepsiHandler = new PepsiHandler(vendingMachine);
        SnackDispenseHandler cheetosHandler = new CheetosHandler(vendingMachine);
        SnackDispenseHandler doritosHandler = new DoritosHandler(vendingMachine);
        SnackDispenseHandler kitKatHandler = new KitKatHandler(vendingMachine);
        SnackDispenseHandler snickersHandler = new SnickersHandler(vendingMachine);

        cokeHandler.setNextHandler(pepsiHandler);
        pepsiHandler.setNextHandler(cheetosHandler);
        cheetosHandler.setNextHandler(doritosHandler);
        doritosHandler.setNextHandler(kitKatHandler);
        kitKatHandler.setNextHandler(snickersHandler);

        vendingMachine.changeState(new IdleState(vendingMachine));


        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(1.5);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(0.9);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("Snickers");
        vendingMachine.insertMoney(0.9);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("KitKat");
        vendingMachine.insertMoney(0.8);
        vendingMachine.dispenseSnack();
    }
}
