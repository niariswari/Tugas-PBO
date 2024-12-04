import java.util.Scanner;

public class Reservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter passenger name: ");
        String name = scanner.nextLine();

        System.out.println("Enter base fare: ");
        double baseFare = scanner.nextDouble();

        System.out.println("Select ticket class: 1. Economy 2. Business 3. First Class");
        int choice = scanner.nextInt();

        Ticket ticket = null; 
        if (choice == 1) {
            ticket = new EconomyTicket(name, baseFare);
        } else if (choice == 2) {
            ticket = new BusinessTicket(name, baseFare);
        } else if (choice == 3) {
            ticket = new FirstClassTicket(name, baseFare);
        } else {
            System.out.println("Invalid choice. Defaulting to Economy class.");
            ticket = new EconomyTicket(name, baseFare);
        }

        System.out.println("\n--- Ticket Details ---");
        System.out.println(ticket.getDetails());

        scanner.close();
    }
}
