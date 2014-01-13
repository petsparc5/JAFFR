package com.order;

public class HotDog extends Product {
    
    private String name;

    public HotDog() {
        super();
        this.happinessIncrease = new HappinessIncrease(2f, IncreaseType.ADD);
        this.name = "HotDog";
    }

    @Override
    public String getName() {
        return name;
    }
    
}
