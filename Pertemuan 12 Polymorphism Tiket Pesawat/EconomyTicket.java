public class EconomyTicket extends Ticket {
    public EconomyTicket(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        return getBaseFare() * 0.9;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nClass: Economy";
    }
}
