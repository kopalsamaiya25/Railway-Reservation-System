public class Booking {
    String passengerName;
    int trainNo;
    int seatsBooked;

    public Booking(String passengerName, int trainNo, int seatsBooked) {
        this.passengerName = passengerName;
        this.trainNo = trainNo;
        this.seatsBooked = seatsBooked;
    }

    public void display() {
        System.out.println("Passenger: " + passengerName + ", Train No: " + trainNo + ", Seats: " + seatsBooked);
    }
}
