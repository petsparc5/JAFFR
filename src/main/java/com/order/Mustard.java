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
    public int recalculateHappiness(int original) {
        return 1;
    }

}
