package com.training.nagarro.mini.assignment5.model;

import com.training.nagarro.mini.assignment5.strategy.price.DynamicPricingStrategy;

public class Seat {
    private String seatId;
    private BerthType berthType;
    private boolean isBooked;
    private double price;

    public Seat(String seatId, BerthType berthType, double basePrice) {
        this.seatId = seatId;
        this.berthType = berthType;
        this.isBooked = false;
        this.price = basePrice;
    }

    public String getSeatId() {
        return seatId;
    }

    public BerthType getBerthType() {
        return berthType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public double getPrice() {
        return price;
    }

    public void bookSeat(User user) {
        this.isBooked = true;
    }

    public void calculateDynamicPrice(int filledPercentage, DynamicPricingStrategy pricingStrategy) {
        this.price = pricingStrategy.calculatePrice(this.price, filledPercentage);
    }
}
