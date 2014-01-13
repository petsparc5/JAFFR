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
    public void recalculateHappinessIncrease(HappinessIncrease happinessIncrease) {
        happinessIncrease.setIncrease(happinessIncrease.getIncrease() * 2);
    }

}
