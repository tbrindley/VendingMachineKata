package com.pillar;

import com.pillar.vendingmachine.VendingMachine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTests {

    @Test
    public void vendingMachineDisplaysTextThatSaysInsertCoin() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        String expected = "INSERT COIN";
        String actual = vendingMachine.getInsertCoinLabel();

       assertEquals("TestCase 1 failed.  INSERT COIN wasn't the label.",expected, actual);

    }
    
}