import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingTicketMachine machine = new ParkingTicketMachine(3000);

        System.out.print("Masukkan jumlah uang yang ingin dimasukkan: ");
        int amount = scanner.nextInt();
        machine.insertMoney(amount);
        
        machine.issueTicket();
        int purchasedTime = machine.getTimePurchased(); 
        System.out.println("Waktu parkir yang dibeli: " + purchasedTime + " jam.");
        System.out.println("Saldo setelah mengeluarkan tiket: " + machine.getBalance());
        
        scanner.close();
    }
}
