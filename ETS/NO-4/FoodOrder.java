import java.util.ArrayList;
import java.util.List;

public class FoodOrder {
    private List<Menu> orderedMenu;
    private int totalPrice;
    private boolean isPaid;

    public FoodOrder() {
        this.orderedMenu = new ArrayList<>();
        this.totalPrice = 0;
        this.isPaid = false;
    }

    public void addMenu(Menu menu) {
        orderedMenu.add(menu);
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        totalPrice = 0;
        for (Menu menu : orderedMenu) {
            totalPrice += menu.getPrice();
        }
    }

    public void markAsPaid() {
        isPaid = true;
    }

    public void displayOrder(boolean showPaymentStatus) {
        System.out.println("\nOrder Details:");
        for (Menu menu : orderedMenu) {
            System.out.println("- " + menu.getName() + ": Rp" + menu.getPrice());
        }
        System.out.println("Total Price: Rp" + totalPrice);
        if (showPaymentStatus) {
            System.out.println("Paid: " + (isPaid ? "Yes" : "No"));
        }
    }
}
