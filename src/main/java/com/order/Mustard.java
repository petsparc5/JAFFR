package com.order;

public class Mustard implements Extra {
    
    private String name;

    public Mustard() {
        this.name = "Mustard";
    }

    public String getName() {
        return name;
    }

    public int recalculateHappiness(int original) {
        return 1;
    }

}
