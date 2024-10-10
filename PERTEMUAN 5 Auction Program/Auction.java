import java.util.ArrayList;

public class Auction {
    private ArrayList<Item> items;

    public Auction() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void showItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    public void showWinners() {
        for (Item item : items) {
            item.showWinner();
        }
    }
}
