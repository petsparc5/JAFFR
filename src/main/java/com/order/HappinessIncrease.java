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
    public void setIncrease(float increase) {
        this.increase = increase;
    }
    public IncreaseType getIncreaseType() {
        return increaseType;
    }
    public void setIncreaseType(IncreaseType increaseType) {
        this.increaseType = increaseType;
    }
    
    

}
