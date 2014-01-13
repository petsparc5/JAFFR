package com.order;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    
    private List<Extra> extras = new ArrayList<>();
    private int happiness = 0;
    
    public void recalculateHappiness() {
        for (Extra extra : extras) {
            happiness = extra.recalculateHappiness(happiness);
        }
    }
    
    public void addExtra(Extra extra) {
        extras.add(extra);
    }
    
    public int getHappiness() {
        recalculateHappiness();
        return happiness;
    }

}
