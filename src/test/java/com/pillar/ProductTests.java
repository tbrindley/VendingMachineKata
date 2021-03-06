package com.pillar;

import com.pillar.coins.Coin;
import com.pillar.product.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/***********************************************************
 * This class contains all tests related to product inventory &
 * product price.
 **********************************************************/

public class ProductTests {

    @Test
    public void testToMakeSureColaAttributesAreSetAndReturnedCorrectly() throws Exception {
        Product cola = Product.getCola();
        double expectedPrice = 1.00;
        double actualPrice = cola.getPrice();

        int expectedQuantity = 10;
        int actualQuantity = cola.getQuantityInStock();

        String expectedName = "Cola";
        String actualName = cola.getName();

        assertEquals("TestCase 1, Part 1 Failed:  Price didn't match",expectedPrice, actualPrice, 0.001);
        assertEquals("TestCase 1, Part 2 Failed:  Quantity didn't match",expectedQuantity, actualQuantity, 0.001);
        assertEquals("TestCase 1, Part 3 Failed:  Name didn't match",expectedName, actualName);

    }

    @Test
    public void testToMakeSureChipsAttributesAreSetAndReturnedCorrectly() throws Exception {
        Product chips = Product.getChips();
        double expectedPrice = 0.50;
        double actualPrice = chips.getPrice();

        int expectedQuantity = 13;
        int actualQuantity = chips.getQuantityInStock();

        String expectedName = "Chips";
        String actualName = chips.getName();

        assertEquals("TestCase 1, Part 1 Failed:  Price didn't match",expectedPrice, actualPrice, 0.001);
        assertEquals("TestCase 1, Part 2 Failed:  Quantity didn't match",expectedQuantity, actualQuantity, 0.001);
        assertEquals("TestCase 1, Part 3 Failed:  Name didn't match",expectedName, actualName);

    }

    @Test
    public void testToMakeSureCandyAttributesAreSetAndReturnedCorrectly() throws Exception {
        Product candy = Product.getCandy();
        double expectedPrice = 0.65;
        double actualPrice = candy.getPrice();

        int expectedQuantity = 15;
        int actualQuantity = candy.getQuantityInStock();

        String expectedName = "Candy";
        String actualName = candy.getName();

        assertEquals("TestCase 1, Part 1 Failed:  Price didn't match",expectedPrice, actualPrice, 0.001);
        assertEquals("TestCase 1, Part 2 Failed:  Quantity didn't match",expectedQuantity, actualQuantity, 0.001);
        assertEquals("TestCase 1, Part 3 Failed:  Name didn't match",expectedName, actualName);

    }
}