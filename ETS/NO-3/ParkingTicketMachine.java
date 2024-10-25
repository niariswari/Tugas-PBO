public class ParkingTicketMachine {
    private int balance;      
    private int ticketPrice;  
    private int ticketTime;    

    public ParkingTicketMachine(int ticketPrice) {
        this.balance = 0;
        this.ticketPrice = ticketPrice;
        this.ticketTime = 0;
    }

    public void insertMoney(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Uang sebesar " + amount + " berhasil ditambahkan. Saldo sekarang: " + balance);
        } 
        else {
            System.out.println("Uang tidak valid! Harap coba lagi.");
        }
    }

    public void issueTicket() {
        if (balance >= ticketPrice) {
            ticketTime = balance / ticketPrice;
            int totalCost = ticketTime * ticketPrice;
            balance -= totalCost; 
            System.out.println("Tiket dikeluarkan! Waktu parkir yang dibeli: " + ticketTime + " jam.");
            System.out.println("Saldo setelah mengeluarkan tiket: " + balance);
        } 
        else {
            System.out.println("Saldo tidak cukup untuk mengeluarkan tiket.");
        }
    }


    public int getTimePurchased() {
        return ticketTime;
    }

    public int getBalance() {
        return balance;
    }
}
