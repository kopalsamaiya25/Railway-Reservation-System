public class Train {
    int trainNo;
    String trainName;
    String source;
    String destination;
    int totalSeats;
    int availableSeats;

    public Train(int trainNo, String trainName, String source, String destination, int totalSeats) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public void display() {
        System.out.println("Train No: " + trainNo + ", Name: " + trainName + ", From: " + source + ", To: " + destination + ", Available Seats: " + availableSeats);
    }
}
