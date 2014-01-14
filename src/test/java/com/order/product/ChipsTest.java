package com.order.product;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.order.extra.Extra;
import com.order.extra.Ketchup;
import com.order.product.Chips;
import com.order.product.Product;

public class ChipsTest {

    private Product underTest;
    
    @Before
    public void setUp() {
        underTest = new Chips();
    }
    
    @Test
    public void testGetPrice() {
        //Given
        //When
        float actual = underTest.getPrice();
        //Then
        Assert.assertEquals(1.99f, actual);
    }
    
    @Test
    public void testGetPriceWithExtras() {
        //Given
        Extra extra1 = new Ketchup();
        underTest.addExtra(extra1);
        //When
        float actual = underTest.getPrice();
        //Then
        Assert.assertEquals(2.24f, actual);
    }
    
    @Test
    public void testRecalculateHappiness() {
        //Given
        //When
        float actual = underTest.getHappiness(20);
        //Then
        Assert.assertEquals(21f, actual);
    }
    
    @Test
    public void testRecalculateHappinessWithExtras() {
        //Given
        Extra extra1 = new Ketchup();
        underTest.addExtra(extra1);
        //When
        float actual = underTest.getHappiness(400);
        //Then
        Assert.assertEquals(440f, actual);
    }
    
    @Test
    public void testName() {
        //Given
        //When
        String actual = underTest.getName();
        //Then
        Assert.assertEquals("Chips", actual);
    }
}
