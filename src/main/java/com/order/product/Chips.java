package com.order.product;

import com.order.happiness.HappinessIncrease;
import com.order.happiness.IncreaseType;

public class Chips extends Product {
    
    private String name;

    public Chips() {
        super();
        this.happinessIncrease = new HappinessIncrease(5f, IncreaseType.MULTIPLY);
        this.name = "Chips";
        this.price = 1.99f;
        
    }

    @Override
    public String getName() {
        return name;
    }

}
