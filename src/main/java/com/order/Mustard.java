package com.order;

public class Mustard implements Extra {
    
    private String name;
    private float price;

    public Mustard() {
        this.name = "Mustard";
        this.price = 0.75f;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public HappinessIncrease recalculateHappinessIncrease(HappinessIncrease happinessIncrease) {
        return new HappinessIncrease(1, IncreaseType.ADD);
    }

    @Override
    public float getPrice() {
        return price;
    }

}
