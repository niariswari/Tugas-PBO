public class BusinessTicket extends Ticket {
    public BusinessTicket(String passengerName, double baseFare) {
        super(passengerName, baseFare);
    }

    @Override
    public double calculateFare() {
        return getBaseFare() * 1.25; 
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\nClass: Business";
    }
}
