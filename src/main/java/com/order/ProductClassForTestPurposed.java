package com.order;

public class ProductClassForTestPurposed extends Product {
    
    

    public ProductClassForTestPurposed() {
        super();
        this.happinessIncrease = new HappinessIncrease(5, IncreaseType.ADD);
    }

    @Override
    public String getName() {
        return "Not A Product";
    }

}
