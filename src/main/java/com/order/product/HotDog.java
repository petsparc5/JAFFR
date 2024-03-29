package com.order.product;

import com.order.happiness.HappinessIncrease;
import com.order.happiness.IncreaseType;

public class HotDog extends Product {
    
    private String name;

    public HotDog() {
        super();
        this.happinessIncrease = new HappinessIncrease(2f, IncreaseType.ADD);
        this.name = "HotDog";
        this.price = 2.99f;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
