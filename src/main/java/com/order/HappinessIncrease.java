package com.order;

public class HappinessIncrease {
    
    private float increase;
    private IncreaseType increaseType;
    
    public HappinessIncrease(float increase, IncreaseType increaseType) {
        super();
        this.increase = increase;
        this.increaseType = increaseType;
    }
    public float getIncrease() {
        return increase;
    }
    public IncreaseType getIncreaseType() {
        return increaseType;
    }   

}
