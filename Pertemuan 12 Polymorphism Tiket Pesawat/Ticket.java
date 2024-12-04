public class Ticket {
    private String passengerName;
    private double baseFare;

    public Ticket(String passengerName, double baseFare) {
        this.passengerName = passengerName;
        this.baseFare = baseFare;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public double calculateFare() {
        return baseFare;
    }

    public String getDetails() {
        return "Passenger Name: " + passengerName + "\nFare: " + calculateFare();
    }
}
