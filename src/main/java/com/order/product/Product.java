package com.order.product;

import java.util.ArrayList;
import java.util.List;

import com.order.extra.Extra;
import com.order.happiness.HappinessIncrease;

public abstract class Product {
    
    public float price;
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
    
    public float getPrice() {
        float answer = price;
        for (Extra extra : extras) {
            answer += extra.getPrice();
        }
        return answer;
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
