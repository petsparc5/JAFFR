package com.order;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    
    private List<Extra> extras = new ArrayList<>();
    public HappinessIncrease happinessIncrease;
    
    private HappinessIncrease recalculateHappinessUsingExtras() {
        HappinessIncrease answer = happinessIncrease;
        for (Extra extra : extras) {
            answer = extra.recalculateHappinessIncrease(answer);
        }
        return answer;
    }
    
    public void addExtra(Extra extra) {
        extras.add(extra);
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public float getHappiness(float original) {
        HappinessIncrease newHappinessIncrease = recalculateHappinessUsingExtras();
        float answer = 0;
        switch(newHappinessIncrease.getIncreaseType()){
            case ADD:
            answer = original + newHappinessIncrease.getIncrease();
            break;
            case MULTIPLY:
            answer =  original * (1+newHappinessIncrease.getIncrease()/100);
            break;
        }
        return answer;
    }
    
    public abstract String getName();
}
