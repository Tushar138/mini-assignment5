package com.training.nagarro.mini.assignment5.strategy.price;

public interface DynamicPricingStrategy {
    double calculatePrice(double basePrice, int filledPercentage);
}
