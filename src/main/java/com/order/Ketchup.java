package com.order;

public class Ketchup implements Extra {
    
    private String name;

    public Ketchup() {
        this.name = "Ketchup";
    }

    public String getName() {
        return name;
    }

    public int recalculateHappiness(int original) {
        return original * 2;
    }

}
