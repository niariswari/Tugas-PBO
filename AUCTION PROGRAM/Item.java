import java.util.HashMap;

public class Item {
    private String name;
    private double startingPrice;
    private double highestBid;
    private String highestBidder;
    private boolean auctionOpen;  
    
    public Item(String name, double startingPrice) {
        this.name = name;
        this.startingPrice = startingPrice;
        this.highestBid = 0;
        this.highestBidder = "";
        this.auctionOpen = true;  
    }

    public String getName() {
        return name;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public String getHighestBidder() {
        return highestBidder;
    }

    public boolean isAuctionOpen() {
        return auctionOpen;
    }

    public void openAuction() {
        this.auctionOpen = true;
    }

    public void closeAuction() {
        this.auctionOpen = false;
    }

    public void setBid(String bidderName, double bidAmount) {
        if (!auctionOpen) {
            System.out.println("The auction for this item is closed.");
            return;
        }

        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            highestBidder = bidderName;
            System.out.println("New highest bid for " + name + ": " + bidAmount + " by " + bidderName);
        } 
        else {
            System.out.println("Bid too low. Current highest bid is: " + highestBid);
        }
    }

    public void showWinner() {
        if (highestBidder.isEmpty()) {
            System.out.println("No bids were placed on " + name);
        } 
        else {
            System.out.println("The winner for " + name + " is " + highestBidder + " with a bid of " + highestBid);
        }
    }

    public String toString() {
        String auctionStatus = auctionOpen ? "AUCTION OPEN" : "AUCTION CLOSED";  // Status auction
        return name + " - Starting Price: " + startingPrice + ", " + auctionStatus;
    }
}
