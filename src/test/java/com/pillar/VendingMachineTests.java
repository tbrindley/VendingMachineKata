package com.pillar;

import com.pillar.coins.Coin;
import com.pillar.vendingmachine.VendingMachine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTests {
    VendingMachine vendingMachine = new VendingMachine();
    @Test
    public void vendingMachineDisplaysTextThatSaysInsertCoin() throws Exception {

        String expected = "INSERT COIN";
        String actual = vendingMachine.getInsertCoinLabel();

       assertEquals("Test Case 1 failed.  INSERT COIN wasn't the label.",expected, actual);

    }
    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsWeight() throws Exception{
        Coin penny = Coin.getPenny();
        boolean expected = true;
        boolean actual = vendingMachine.isCoinBasedOffWeight(penny.getWeight());

        assertEquals("Test Case 2 failed.  Method didn't find the coin to be a penny", expected, actual);
    }
}