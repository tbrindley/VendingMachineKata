package com.pillar;

import com.pillar.coins.Coin;
import com.pillar.vendingmachine.VendingMachine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTests {
    private VendingMachine vendingMachine = new VendingMachine();
    private Coin penny = Coin.getPenny();
    private Coin nickel = Coin.getNickel();
    private Coin dime = Coin.getDime();
    private Coin quarter = Coin.getQuarter();
    @Test
    public void vendingMachineDisplaysTextThatSaysInsertCoin() throws Exception {

        String expected = "INSERT COIN";
        String actual = vendingMachine.getInsertCoinLabel();

       assertEquals("Test Case 1 failed.  INSERT COIN wasn't the label.",expected, actual);

    }
    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsWeightAndWidth() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.isCoinBasedOffWeight(penny.getWeight(), vendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 2 failed.  Method didn't find the coin to be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsWidth() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.isCoinBasedOffWidth(penny.getWidth(), vendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 3 failed.  Method didn't find the coin to be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsThickness() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.isCoinBasedOffThickness(penny.getThickness(), vendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 4 failed.  Method didn't find the coin to be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsWeightWidthAndThickness() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.coinTypeChecker(penny, vendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 5 failed.  Method didn't find the coin to be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsANickelBasedOffItsWeightWidthAndThickness() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.coinTypeChecker(nickel, vendingMachine.IS_COIN_A_NICKEL);

        assertEquals("Test Case 6 failed.  Method didn't find the coin to be a nickel", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesThatACoinIsNotAPenny() throws Exception{
        boolean expected = false;
        boolean actual = vendingMachine.coinTypeChecker(dime, vendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 7 failed.  Method still thought coin should be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsADimeBasedOffItsWeightWidthAndThickness() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.coinTypeChecker(dime, vendingMachine.IS_COIN_A_DIME);

        assertEquals("Test Case 8 failed.  Method didn't find the coin to be a dime", expected, actual);
    }


    @Test
    public void vendingMachineDeterminesIfCoinIsAQuarterBasedOffItsWeightWidthAndThickness() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.coinTypeChecker(quarter, vendingMachine.IS_COIN_A_QUARTER);

        assertEquals("Test Case 9 failed.  Method didn't find the coin to be a dime", expected, actual);
    }

    @Test
    public void vendingMachineReadsCoinAsPennyAndRejectsIt() throws Exception{
        String expected = "THIS MACHINE DOES NOT ACCEPT PENNIES";
        String actual = vendingMachine.acceptOrRejectCoin(penny);

        assertEquals("Test Case 10 failed.  Coin was accepted", expected, actual);
    }
}