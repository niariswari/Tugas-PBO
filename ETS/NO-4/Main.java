import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MenuCatalog catalog = new MenuCatalog();
        catalog.addMenu(new Menu("Gado-gado", 20000));
        catalog.addMenu(new Menu("Rawon Iga", 35000));
        catalog.addMenu(new Menu("Nasi Goreng", 25000));
        catalog.addMenu(new Menu("Soto ayam", 20000));
        catalog.addMenu(new Menu("Ayam bakar", 25000));

        catalog.displayMenu();

        FoodOrder order = new FoodOrder();
        String input;
        do {
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan (atau 'q' untuk keluar): ");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("q")) {
                try {
                    int menuIndex = Integer.parseInt(input) - 1;
                    if (menuIndex >= 0 && menuIndex < catalog.getMenuList().size()) {
                        order.addMenu(catalog.getMenuList().get(menuIndex));
                        System.out.println(catalog.getMenuList().get(menuIndex).getName() + " berhasil ditambahkan.");
                    } else {
                        System.out.println("Nomor menu tidak valid.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid. Harap masukkan nomor.");
                }
            }
        } while (!input.equalsIgnoreCase("q"));

        order.displayOrder(false);

        System.out.print("\nApakah pesanan sudah dibayar? (y/n): ");
        String paidInput = scanner.nextLine();
        if (paidInput.equalsIgnoreCase("y")) {
            order.markAsPaid();
        }

        System.out.println("\nSetelah pembayaran:");
        order.displayOrder(true);

        scanner.close();
    }
}
