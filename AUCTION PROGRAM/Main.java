import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Auction auction = new Auction();
        
        auction.addItem(new Item("Nike Air Jordan", 100));
        auction.addItem(new Item("Adidas Samba", 100));
        auction.addItem(new Item("New Balance 2002R", 100));

        boolean keepBidding = true;
        while (keepBidding) {
            System.out.println("\nAuction Status:");
            auction.showItems(); 

            System.out.println("What would you like to do?");
            System.out.println("1. Place a bid");
            System.out.println("2. Open auction for an item");
            System.out.println("3. Close auction for an item");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.println("Enter bidder name:");
                    String bidderName = scanner.nextLine();

                    int itemNumber;
                    while (true) {
                        System.out.println("Select item number to bid on:");
                        auction.showItems();
                        itemNumber = scanner.nextInt();
                        scanner.nextLine();  
                        
                        if (itemNumber > 0 && itemNumber <= auction.getItems().size()) {
                            Item selectedItem = auction.getItems().get(itemNumber - 1);
                            if (!selectedItem.isAuctionOpen()) {
                                System.out.println("Auction for this item is closed.");
                                continue; 
                            }
                            break;
                        } 
                        else {
                            System.out.println("Invalid item number! Please enter a valid number.");
                        }
                    }

                    System.out.println("Enter your bid:");
                    double bidAmount = scanner.nextDouble();
                    scanner.nextLine();  
                    
                    Item selectedItem = auction.getItems().get(itemNumber - 1);
                    selectedItem.setBid(bidderName, bidAmount);
                    break;

                case 2:
                    System.out.println("Select item number to open auction:");
                    itemNumber = scanner.nextInt();
                    scanner.nextLine();  
                    if (itemNumber > 0 && itemNumber <= auction.getItems().size()) {
                        auction.getItems().get(itemNumber - 1).openAuction();
                        System.out.println("Auction for item " + auction.getItems().get(itemNumber - 1).getName() + " is now open.");
                    } 
                    else {
                        System.out.println("Invalid item number!");
                    }
                    break;

                case 3:
                    System.out.println("Select item number to close auction:");
                    itemNumber = scanner.nextInt();
                    scanner.nextLine();  
                    if (itemNumber > 0 && itemNumber <= auction.getItems().size()) {
                        auction.getItems().get(itemNumber - 1).closeAuction();
                        System.out.println("Auction for item " + auction.getItems().get(itemNumber - 1).getName() + " is now closed.");
                    } 
                    else {
                        System.out.println("Invalid item number!");
                    }
                    break;

                case 4:
                    keepBidding = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }

        auction.showWinners();
    }
}
