package com.order.extra;

import com.order.happiness.HappinessIncrease;

public interface Extra {
            
    public String getName();
    public HappinessIncrease recalculateHappinessIncrease(HappinessIncrease happinessIncrease);
    
    public float getPrice();

}
