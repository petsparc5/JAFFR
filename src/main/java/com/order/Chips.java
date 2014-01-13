package com.order;

public class Chips extends Product {
    
    private String name;

    public Chips() {
        super();
        this.happinessIncrease = new HappinessIncrease(5f, IncreaseType.MULTIPLY);
        this.name = "Chips";
        
    }

    @Override
    public String getName() {
        return name;
    }

}
