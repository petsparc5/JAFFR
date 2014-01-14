package com.order.extra;

import com.order.happiness.HappinessIncrease;

public class Ketchup implements Extra {
    
    private String name;
    private float price;

    public Ketchup() {
        this.name = "Ketchup";
        this.price = 0.25f;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public HappinessIncrease recalculateHappinessIncrease(HappinessIncrease happinessIncrease) {
        return new HappinessIncrease(happinessIncrease.getIncrease() * 2, happinessIncrease.getIncreaseType());
    }
    
    @Override
    public float getPrice() {
        return price;
    }

}
