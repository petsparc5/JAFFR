package com.order.extra;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.order.extra.Extra;
import com.order.extra.Ketchup;
import com.order.happiness.HappinessIncrease;
import com.order.happiness.IncreaseType;

public class KetchupTest {
    
    private Extra underTest;
    
    @Before
    public void setUp() {
        underTest = new Ketchup();
    }
    
    @Test
    public void testConstructor() {
        //Given
        //When
        String actualAnswer = underTest.getName();
        float actualPrice = underTest.getPrice();
        //Then
        Assert.assertEquals("Ketchup", actualAnswer);
        Assert.assertEquals(0.25f, actualPrice);
    }
    
    @Test
    public void testRecalculateHappinessIncreaseWithInitialMultiply() {
        //Given
        HappinessIncrease happinessIncrease = new HappinessIncrease(5, IncreaseType.MULTIPLY);
        //When
        HappinessIncrease newHappinessIncrease = underTest.recalculateHappinessIncrease(happinessIncrease);
        //Then
        Assert.assertEquals(10.0f, newHappinessIncrease.getIncrease());
        Assert.assertEquals(IncreaseType.MULTIPLY, newHappinessIncrease.getIncreaseType());
    }
    
    @Test
    public void testRecalculateHappinessWithANonZeroHappinessLevel() {
        //Given
        HappinessIncrease happinessIncrease = new HappinessIncrease(2, IncreaseType.ADD);
        //When
        HappinessIncrease newHappinessIncrease = underTest.recalculateHappinessIncrease(happinessIncrease);
        //Then
        Assert.assertEquals(4.0f, newHappinessIncrease.getIncrease());
        Assert.assertEquals(IncreaseType.ADD, newHappinessIncrease.getIncreaseType());
    }

}
