package com.pillar;

import com.pillar.coins.Coin;
import org.junit.Test;

import static org.junit.Assert.*;

/***********************************************************
 * This class contains all tests associated with the attributes
 * associated with coins. The test methods ensure that each coins
 * singleton returns the correct weight, width, thickness and value.
 **********************************************************/

public class CoinTests {

    @Test
    public void readTheWidthAndWeightAndThicknessAndValueOfPenny() throws Exception {
        Coin penny = Coin.getPenny();
        double expectedWeight = 2.5;
        double actualWeight = penny.getWeight();

        double expectedWidth = 19.5;
        double actualWidth = penny.getWidth();

        double expectedThickness = 1.55;
        double actualThickness = penny.getThickness();

        double expectedValue = .01;
        double actualValue = penny.getValue();

        assertEquals("TestCase 1, Part 1 Failed:  Penny didn't weight 2.5g",expectedWeight, actualWeight, 0.001);
        assertEquals("TestCase 1, Part 2 Failed:  Penny's width wasn't 19.5mm",expectedWidth, actualWidth, 0.001);
        assertEquals("TestCase 1, Part 3 Failed:  Penny's thickness wasn't 1.55mm",expectedThickness, actualThickness, 0.001);
        assertEquals("TestCase 1, Part 4 Failed:  Penny's value wasn't .01",expectedValue, actualValue, 0.001);

    }

    @Test
    public void readTheWidthAndWeightAndThicknessAndValueOfNickel() throws Exception{
        Coin nickel = Coin.getNickel();

        double expectedWeight = 5.0;
        double actualWeight = nickel.getWeight();

        double expectedWidth = 21.21;
        double actualWidth = nickel.getWidth();

        double expectedThickness = 1.95;
        double actualThickness = nickel.getThickness();

        double expectedValue = .05;
        double actualValue = nickel.getValue();

        assertEquals("TestCase 2, Part 1 Failed:  Nickel didn't weight 5.0g",expectedWeight, actualWeight, 0.001);
        assertEquals("TestCase 2, Part 2 Failed:  Nickel's width wasn't 21.21mm",expectedWidth, actualWidth, 0.001);
        assertEquals("TestCase 2, Part 3 Failed:  Nickel's thickness wasn't 1.95mm",expectedThickness, actualThickness, 0.001);
        assertEquals("TestCase 2, Part 4 Failed:  Nickel's value wasn't .05",expectedValue, actualValue, 0.001);
    }

    @Test
    public void readTheWidthAndWeightAndThicknessAndValueOfDime() throws Exception {
        Coin dime = Coin.getDime();
        double expectedWeight = 2.27;
        double actualWeight = dime.getWeight();

        double expectedWidth = 17.9;
        double actualWidth = dime.getWidth();

        double expectedThickness = 1.35;
        double actualThickness = dime.getThickness();

        double expectedValue = .10;
        double actualValue = dime.getValue();

        assertEquals("TestCase 3, Part 1 Failed:  Dime didn't weight 2.27g",expectedWeight, actualWeight, 0.001);
        assertEquals("TestCase 3, Part 2 Failed:  Dime's width wasn't 17.9mm",expectedWidth, actualWidth, 0.001);
        assertEquals("TestCase 3, Part 3 Failed:  Dime's thickness wasn't 1.35mm",expectedThickness, actualThickness, 0.001);
        assertEquals("TestCase 3, Part 4 Failed:  Dime's value wasn't .10",expectedValue, actualValue, 0.001);

    }

    @Test
    public void readTheWidthAndWeightAndThicknessAndValueOfQuarter() throws Exception {
        Coin quarter = Coin.getQuarter();
        double expectedWeight = 5.67;
        double actualWeight = quarter.getWeight();

        double expectedWidth = 24.26;
        double actualWidth = quarter.getWidth();

        double expectedThickness = 1.75;
        double actualThickness = quarter.getThickness();

        double expectedValue = .25;
        double actualValue = quarter.getValue();

        assertEquals("TestCase 4, Part 1 Failed:  Quarter didn't weight 5.67g",expectedWeight, actualWeight, 0.001);
        assertEquals("TestCase 4, Part 2 Failed:  Quarter's width wasn't 24.26mm",expectedWidth, actualWidth, 0.001);
        assertEquals("TestCase 4, Part 3 Failed:  Quarter's thickness wasn't 1.75mm",expectedThickness, actualThickness, 0.001);
        assertEquals("TestCase 4, Part 4 Failed:  Quarter's value wasn't .25",expectedValue, actualValue, 0.001);

    }
}