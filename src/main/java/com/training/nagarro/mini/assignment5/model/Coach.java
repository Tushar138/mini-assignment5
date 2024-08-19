package com.training.nagarro.mini.assignment5.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String coachId;
    private List<Seat> seats;

    public Coach(String coachId) {
        this.coachId = coachId;
        this.seats = new ArrayList<>();
    }

    public String getCoachId() {
        return coachId;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    public boolean isCoachFilled() {
        return getAvailableSeats().isEmpty();
    }

    public int getFilledPercentage() {
        int bookedSeats = (int) seats.stream().filter(Seat::isBooked).count();
        return (bookedSeats * 100) / seats.size();
    }
}
