package com.order.product;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.order.extra.Extra;
import com.order.extra.Ketchup;
import com.order.extra.Mustard;
import com.order.product.Product;
import com.order.product.ProductClassForTestPurposed;

public class ProductTest {
    
    private Product underTest;
    
    @Before
    public void setUp() {
        underTest = new ProductClassForTestPurposed();
    }
    
    @Test
    public void testAddExtra() {
        //Given
        Extra extra1 = new Ketchup();
        Extra extra2 = new Mustard();
        List<Extra> extras = new ArrayList<>();
        extras.add(extra1);
        extras.add(extra2);
        //When
        underTest.addExtra(extra1);
        underTest.addExtra(extra2);
        //Then
        Assert.assertEquals(extras, underTest.getExtras());
    }
    
    @Test
    public void testGetPrice() {
        //Given
        //When
        float actual = underTest.getPrice();
        //Then
        Assert.assertEquals(50.0f, actual);
    }
    
    @Test
    public void testGetPriceWithExtras() {
        //Given
        Extra extra1 = new Ketchup();
        Extra extra2 = new Mustard();
        underTest.addExtra(extra1);
        underTest.addExtra(extra2);
        //When
        float actual = underTest.getPrice();
        //Then
        Assert.assertEquals(51.0f, actual);
    }
    
    @Test
    public void testGetHappiness() {
        //Given
        Extra extra1 = new Ketchup();
        Extra extra2 = new Mustard();
        underTest.addExtra(extra1);
        underTest.addExtra(extra2);
        //When
        float actual = underTest.getHappiness(20);
        //Then
        Assert.assertEquals(21.0f, actual);
    }
    
    @Test
    public void testGetHappinessForDifferentExtras() {
        //Given
        Extra extra1 = new Ketchup();
        Extra extra2 = new Mustard();
        underTest.addExtra(extra2);
        underTest.addExtra(extra1);
        //When
        float actual = underTest.getHappiness(20);
        //Then
        Assert.assertEquals(22.0f, actual);
    }
    
    @Test
    public void testGetNameForTheGenericProduct() {
        //Given
        //When
        String actual = underTest.getName();
        //Then
        Assert.assertEquals("Not A Product", actual);
    }

}
