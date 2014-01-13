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
    public int recalculateHappiness(int original) {
        return original * 2;
    }

}
