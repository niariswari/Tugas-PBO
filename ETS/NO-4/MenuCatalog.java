import java.util.ArrayList;
import java.util.List;

public class MenuCatalog {
    private List<Menu> menuList;

    public MenuCatalog() {
        menuList = new ArrayList<>();
    }

    public void addMenu(Menu menu) {
        menuList.add(menu);
    }

    public void displayMenu() {
        System.out.println("Available Menus:");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).getName() + ": Rp" + menuList.get(i).getPrice());
        }
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
}
