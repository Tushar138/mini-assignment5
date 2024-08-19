package com.training.nagarro.mini.assignment5.model;

import java.time.LocalDateTime;

public class Booking {
    private String bookingId;
    private User user;
    private Seat seat;
    private LocalDateTime bookingTime;

    public Booking(String bookingId, User user, Seat seat) {
        this.bookingId = bookingId;
        this.user = user;
        this.seat = seat;
        this.bookingTime = LocalDateTime.now();
    }

    public void confirmBooking() {
        seat.bookSeat(user);
    }

    public void showBookingDetails() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("User: " + user.getName());
        System.out.println("Seat ID: " + seat.getSeatId());
        System.out.println("Berth: " + seat.getBerthType());
        System.out.println("Meal Preference: " + user.getMealPreference());
        System.out.println("Booking Time: " + bookingTime);
        System.out.println("Price: " + seat.getPrice());
    }
}
