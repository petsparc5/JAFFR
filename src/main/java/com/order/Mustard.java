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
    public HappinessIncrease recalculateHappinessIncrease(HappinessIncrease happinessIncrease) {
        return new HappinessIncrease(1, IncreaseType.ADD);
    }

}
