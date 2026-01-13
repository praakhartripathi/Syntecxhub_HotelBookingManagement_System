# Hotel Booking Management System

A simple Command Line Interface (CLI) application to manage hotel room bookings. This system allows users to view available rooms, book rooms for guests, and cancel existing bookings.

## Features

*   **View Available Rooms**: Lists all rooms that are currently not booked.
*   **Book a Room**: Allows booking a specific room by entering the room number and guest name.
*   **Cancel Booking**: Cancels a booking for a specific room, making it available again.
*   **Room Types**: Supports different room types (Single, Double, Suite).

## Project Structure

*   `HotelBookingSystem.java`: The main entry point of the application containing the menu and logic.
*   `Room.java`: The model class representing a hotel room.

## How to Run

1.  **Compile the Java files:**
    Open a terminal in the project directory and run:
    ```bash
    javac Room.java HotelBookingSystem.java
    ```

2.  **Run the application:**
    ```bash
    java HotelBookingSystem
    ```

## Usage

Upon running the application, you will be presented with a menu:

1.  Select option `1` to see which rooms are free.
2.  Select option `2` to book a room. You will be asked for the Room Number and the Guest Name.
3.  Select option `3` to cancel a booking. You will be asked for the Room Number.
4.  Select option `4` to exit the application.
