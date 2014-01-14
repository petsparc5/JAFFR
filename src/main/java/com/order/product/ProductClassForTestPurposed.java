package com.order.product;

import com.order.happiness.HappinessIncrease;
import com.order.happiness.IncreaseType;

public class ProductClassForTestPurposed extends Product {
    
    

    public ProductClassForTestPurposed() {
        super();
        this.happinessIncrease = new HappinessIncrease(5, IncreaseType.ADD);
        this.price = 50;
    }

    @Override
    public String getName() {
        return "Not A Product";
    }

}
