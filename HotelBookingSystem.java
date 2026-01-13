import java.util.ArrayList;
import java.util.Scanner;

public class HotelBookingSystem {
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Hotel Booking Management System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input.trim());
                switch (choice) {
                    case 1:
                        viewAvailableRooms();
                        break;
                    case 2:
                        bookRoom();
                        break;
                    case 3:
                        cancelBooking();
                        break;
                    case 4:
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Single"));
        rooms.add(new Room(201, "Double"));
        rooms.add(new Room(202, "Double"));
        rooms.add(new Room(301, "Suite"));
    }

    private static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        boolean found = false;
        for (Room room : rooms) {
            if (!room.isBooked) {
                System.out.println(room);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms available.");
        }
    }

    private static void bookRoom() {
        System.out.print("\nEnter Room Number to book: ");
        try {
            String input = scanner.nextLine();
            int roomNumber = Integer.parseInt(input.trim());
            Room room = findRoom(roomNumber);
            if (room != null) {
                if (!room.isBooked) {
                    System.out.print("Enter Guest Name: ");
                    String guestName = scanner.nextLine().trim();
                    if (!guestName.isEmpty()) {
                        room.isBooked = true;
                        room.guestName = guestName;
                        System.out.println("Room " + roomNumber + " booked successfully for " + guestName + ".");
                    } else {
                        System.out.println("Guest name cannot be empty.");
                    }
                } else {
                    System.out.println("Room " + roomNumber + " is already booked.");
                }
            } else {
                System.out.println("Room not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid room number.");
        }
    }

    private static void cancelBooking() {
        System.out.print("\nEnter Room Number to cancel booking: ");
        try {
            String input = scanner.nextLine();
            int roomNumber = Integer.parseInt(input.trim());
            Room room = findRoom(roomNumber);
            if (room != null) {
                if (room.isBooked) {
                    System.out.println("Booking for " + room.guestName + " in Room " + roomNumber + " cancelled.");
                    room.isBooked = false;
                    room.guestName = "";
                } else {
                    System.out.println("Room " + roomNumber + " is not currently booked.");
                }
            } else {
                System.out.println("Room not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid room number.");
        }
    }

    private static Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                return room;
            }
        }
        return null;
    }
}