package com.pillar;

import com.pillar.coins.Coin;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

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


}