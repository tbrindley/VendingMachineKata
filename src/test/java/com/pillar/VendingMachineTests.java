package com.pillar;

import com.pillar.coins.Coin;
import com.pillar.vendingmachine.VendingMachine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTests {
    private VendingMachine vendingMachine = new VendingMachine();
    @Test
    public void vendingMachineDisplaysTextThatSaysInsertCoin() throws Exception {

        String expected = "INSERT COIN";
        String actual = vendingMachine.getInsertCoinLabel();

       assertEquals("Test Case 1 failed.  INSERT COIN wasn't the label.",expected, actual);

    }
    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsWeightAndWidth() throws Exception{
        Coin penny = Coin.getPenny();
        boolean expected = true;
        boolean actual = vendingMachine.isCoinBasedOffWeight(penny.getWeight());

        assertEquals("Test Case 2 failed.  Method didn't find the coin to be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsWidth() throws Exception{
        Coin penny = Coin.getPenny();
        boolean expected = true;
        boolean actual = vendingMachine.isCoinBasedOffWidth(penny.getWidth());

        assertEquals("Test Case 3 failed.  Method didn't find the coin to be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsThickness() throws Exception{
        Coin penny = Coin.getPenny();
        boolean expected = true;
        boolean actual = vendingMachine.isCoinBasedOffThickness(penny.getThickness());

        assertEquals("Test Case 4 failed.  Method didn't find the coin to be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsWeightWidthAndThickness() throws Exception{
        Coin penny = Coin.getPenny();
        boolean expected = true;
        boolean actual = vendingMachine.isCoinAPenny(penny);

        assertEquals("Test Case 5 failed.  Method didn't find the coin to be a penny", expected, actual);
    }
}