package com.training.nagarro.mini.assignment5.strategy.price.impl;

import com.training.nagarro.mini.assignment5.strategy.price.DynamicPricingStrategy;

public class DynamicPricingStrategyImpl implements DynamicPricingStrategy {

    @Override
    public double calculatePrice(double basePrice, int filledPercentage) {
        if (filledPercentage >= 40) {
            return basePrice * 1.18;
        } else if (filledPercentage >= 35) {
            return basePrice * 1.15;
        } else if (filledPercentage >= 30) {
            return basePrice * 1.12;
        } else if (filledPercentage >= 20) {
            return basePrice * 1.10;
        } else {
            return basePrice;
        }
    }
}
