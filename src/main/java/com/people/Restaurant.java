package com.people;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    
    private static final Restaurant INSTANCE_OF_RESTAURANT;
    private static List<Cashier> cashiers; 
    private static Manager manager = new Manager();
    
    static {
        INSTANCE_OF_RESTAURANT = new Restaurant();
        cashiers = new ArrayList<Cashier>();
        manager = new Manager();
        for (int i = 0; i < 10; i++) {
            cashiers.add(new Cashier());
        }
    }
    
    private Restaurant() {}
    
    public static Restaurant getInstance() {
        return INSTANCE_OF_RESTAURANT;
    }

    public List<Cashier> getCashiers() {
        return cashiers;
    }

    public Manager getManager() {
        return manager;
    }
   
}
