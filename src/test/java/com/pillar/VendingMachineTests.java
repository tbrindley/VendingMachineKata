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
        boolean actual = vendingMachine.isCoinBasedOffWeight(penny.getWeight(), vendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 2 failed.  Method didn't find the coin to be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsWidth() throws Exception{
        Coin penny = Coin.getPenny();
        boolean expected = true;
        boolean actual = vendingMachine.isCoinBasedOffWidth(penny.getWidth(), vendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 3 failed.  Method didn't find the coin to be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsThickness() throws Exception{
        Coin penny = Coin.getPenny();
        boolean expected = true;
        boolean actual = vendingMachine.isCoinBasedOffThickness(penny.getThickness(), vendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 4 failed.  Method didn't find the coin to be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsWeightWidthAndThickness() throws Exception{
        Coin penny = Coin.getPenny();
        boolean expected = true;
        boolean actual = vendingMachine.coinTypeChecker(penny, vendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 5 failed.  Method didn't find the coin to be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsANickelBasedOffItsWeightWidthAndThickness() throws Exception{
        Coin nickel = Coin.getNickel();
        boolean expected = true;
        boolean actual = vendingMachine.coinTypeChecker(nickel, vendingMachine.IS_COIN_A_NICKEL);

        assertEquals("Test Case 6 failed.  Method didn't find the coin to be a nickel", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesThatACoinIsNotAPenny() throws Exception{
        Coin dime = Coin.getDime();
        boolean expected = false;
        boolean actual = vendingMachine.coinTypeChecker(dime, vendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 7 failed.  Method still thought coin should be a penny", expected, actual);
    }

    @Test
    public void vendingMachineDeterminesIfCoinIsADimeBasedOffItsWeightWidthAndThickness() throws Exception{
        Coin dime = Coin.getDime();
        boolean expected = true;
        boolean actual = vendingMachine.coinTypeChecker(dime, vendingMachine.IS_COIN_A_DIME);

        assertEquals("Test Case 8 failed.  Method didn't find the coin to be a dime", expected, actual);
    }

}