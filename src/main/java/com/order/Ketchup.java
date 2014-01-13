package com.order;

public class Ketchup implements Extra {
    
    private String name;

    public Ketchup() {
        this.name = "Ketchup";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public HappinessIncrease recalculateHappinessIncrease(HappinessIncrease happinessIncrease) {
        return new HappinessIncrease(happinessIncrease.getIncrease() * 2, happinessIncrease.getIncreaseType());
    }

}
