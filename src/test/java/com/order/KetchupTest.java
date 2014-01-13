package com.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        //Then
        Assert.assertEquals("Ketchup", actualAnswer);
    }
    
    @Test
    public void testRecalculateHappinessIncreaseWithInitialMultiply() {
        //Given
        HappinessIncrease happinessIncrease = new HappinessIncrease(5, IncreaseType.MULTIPLY);
        //When
        underTest.recalculateHappinessIncrease(happinessIncrease);
        //Then
        Assert.assertEquals(10.0f, happinessIncrease.getIncrease());
        Assert.assertEquals(IncreaseType.MULTIPLY, happinessIncrease.getIncreaseType());
    }
    
    @Test
    public void testRecalculateHappinessWithANonZeroHappinessLevel() {
        //Given
        HappinessIncrease happinessIncrease = new HappinessIncrease(2, IncreaseType.ADD);
        //When
        underTest.recalculateHappinessIncrease(happinessIncrease);
        //Then
        Assert.assertEquals(4.0f, happinessIncrease.getIncrease());
        Assert.assertEquals(IncreaseType.ADD, happinessIncrease.getIncreaseType());
    }

}
