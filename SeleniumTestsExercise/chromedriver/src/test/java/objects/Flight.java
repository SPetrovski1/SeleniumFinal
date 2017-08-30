package objects;

public class Flight {

    private String origin;
    private String destination;


    public Flight(String origin, String destination, String departDate, String returnDate, int adults, int children, int infants) {
        this.origin = origin;
        this.destination = destination;

    }

    public Flight() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

