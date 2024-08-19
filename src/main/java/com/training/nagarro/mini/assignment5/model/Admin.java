package com.training.nagarro.mini.assignment5.model;

public class Admin {
    private String adminId;

    public Admin(String adminId) {
        this.adminId = adminId;
    }

    public void viewCoachStatus(Train train) {
        for (Coach coach : train.getCoaches()) {
            System.out.println("Coach ID: " + coach.getCoachId());
            System.out.println("Filled Percentage: " + coach.getFilledPercentage() + "%");
            System.out.println("Available Seats: " + coach.getAvailableSeats().size());
            System.out.println("----");
        }
    }
}
