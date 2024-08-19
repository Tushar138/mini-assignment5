package com.training.nagarro.mini.assignment5.model;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private String trainId;
    private List<Coach> coaches;

    public Train(String trainId) {
        this.trainId = trainId;
        this.coaches = new ArrayList<>();
    }

    public String getTrainId() {
        return trainId;
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for (Coach coach : coaches) {
            availableSeats.addAll(coach.getAvailableSeats());
        }
        return availableSeats;
    }
}
