
public class TicketMachine
{
    private int price;    
    private int balance;  
    private int total;    

    public TicketMachine(int ticketCost) {
        price = ticketCost;
        balance = 0;
        total = 0;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void insertMoney(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Masukkan jumlah yang valid.");
        }
    }
    
    public void printTicket() {
        if (balance >= price) {
            balance -= price;
            
            total += price;
            
            System.out.println("#################");
            System.out.println("# Ticket");
            System.out.println("# Harga: " + price + " unit");
            System.out.println("#################");
            
            System.out.println("Sisa saldo: " + balance + " unit.");
        } else {
            System.out.println("Saldo tidak cukup. Silakan masukkan uang lebih.");
        }
    }
    
    public int getTotal() {
        return total;
    }
    
    public void refundBalance() {
        System.out.println("Mengembalikan saldo: " + balance + " unit.");
        balance = 0;
    }
}
