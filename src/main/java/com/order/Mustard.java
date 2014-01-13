package com.order;

public class Mustard implements Extra {
    
    private String name;

    public Mustard() {
        this.name = "Mustard";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void recalculateHappinessIncrease(HappinessIncrease happinessIncrease) {
        happinessIncrease.setIncrease(1);
        happinessIncrease.setIncreaseType(IncreaseType.ADD);
        
    }

}
