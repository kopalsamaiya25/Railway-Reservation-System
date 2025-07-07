import java.util.*;

public class RailwaySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Train> trains = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        // Sample trains
        trains.add(new Train(101, "Express A", "City A", "City B", 50));
        trains.add(new Train(102, "Express B", "City B", "City C", 30));
        trains.add(new Train(103, "Express C", "City A", "City C", 40));

        while (true) {
            System.out.println("\n1. Show Trains\n2. Book Ticket\n3. Cancel Ticket\n4. View Bookings\n5. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Train t : trains) t.display();
                    break;

                case 2:
                    System.out.print("Enter passenger name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter train number: ");
                    int tNo = sc.nextInt();
                    System.out.print("Enter number of seats to book: ");
                    int seats = sc.nextInt();

                    Train selectedTrain = null;
                    for (Train t : trains) {
                        if (t.trainNo == tNo) {
                            selectedTrain = t;
                            break;
                        }
                    }

                    if (selectedTrain != null && selectedTrain.availableSeats >= seats) {
                        selectedTrain.availableSeats -= seats;
                        bookings.add(new Booking(name, tNo, seats));
                        System.out.println("Booking successful!");
                    } else {
                        System.out.println("Booking failed: Not enough seats or train not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter passenger name to cancel: ");
                    sc.nextLine();
                    String cancelName = sc.nextLine();
                    boolean found = false;
                    Iterator<Booking> iterator = bookings.iterator();

                    while (iterator.hasNext()) {
                        Booking b = iterator.next();
                        if (b.passengerName.equalsIgnoreCase(cancelName)) {
                            for (Train t : trains) {
                                if (t.trainNo == b.trainNo) {
                                    t.availableSeats += b.seatsBooked;
                                    break;
                                }
                            }
                            iterator.remove();
                            found = true;
                            System.out.println("Booking canceled successfully!");
                            break;
                        }
                    }

                    if (!found) System.out.println("No booking found for the name.");
                    break;

                case 4:
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings yet.");
                    } else {
                        for (Booking b : bookings) b.display();
                    }
                    break;

                case 5:
                    System.out.println("Exiting system. Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
