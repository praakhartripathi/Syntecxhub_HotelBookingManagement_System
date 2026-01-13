public class Room {
    int roomNumber;
    String type;
    boolean isBooked;
    String guestName;

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
        this.guestName = "";
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " [" + type + "] - " + (isBooked ? "Booked by " + guestName : "Available");
    }
}