package com.pillar;

import com.pillar.coins.Coin;
import com.pillar.vendingmachine.VendingMachine;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/****************************************************
 * The following tests ensure the vending machine is able to function correctly.
 * These tests ensure the machine is able to read coins correctly, display output, dispense change,
 * and keep track of inventory.
 ***************************************************/

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
        boolean actual = vendingMachine.isCoinBasedOffWeight(penny.getWeight(), VendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 2 failed.  Method didn't find the coin to be a penny", expected, actual);
    }
    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsWidth() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.isCoinBasedOffWidth(penny.getWidth(), VendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 3 failed.  Method didn't find the coin to be a penny", expected, actual);
    }
    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsThickness() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.isCoinBasedOffThickness(penny.getThickness(), VendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 4 failed.  Method didn't find the coin to be a penny", expected, actual);
    }
    @Test
    public void vendingMachineDeterminesIfCoinIsAPennyBasedOffItsWeightWidthAndThickness() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.coinTypeChecker(penny, VendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 5 failed.  Method didn't find the coin to be a penny", expected, actual);
    }
    @Test
    public void vendingMachineDeterminesIfCoinIsANickelBasedOffItsWeightWidthAndThickness() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.coinTypeChecker(nickel, VendingMachine.IS_COIN_A_NICKEL);

        assertEquals("Test Case 6 failed.  Method didn't find the coin to be a nickel", expected, actual);
    }
    @Test
    public void vendingMachineDeterminesThatACoinIsNotAPenny() throws Exception{
        boolean expected = false;
        boolean actual = vendingMachine.coinTypeChecker(dime, VendingMachine.IS_COIN_A_PENNY);

        assertEquals("Test Case 7 failed.  Method still thought coin should be a penny", expected, actual);
    }
    @Test
    public void vendingMachineDeterminesIfCoinIsADimeBasedOffItsWeightWidthAndThickness() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.coinTypeChecker(dime, VendingMachine.IS_COIN_A_DIME);

        assertEquals("Test Case 8 failed.  Method didn't find the coin to be a dime", expected, actual);
    }
    @Test
    public void vendingMachineDeterminesIfCoinIsAQuarterBasedOffItsWeightWidthAndThickness() throws Exception{
        boolean expected = true;
        boolean actual = vendingMachine.coinTypeChecker(quarter, VendingMachine.IS_COIN_A_QUARTER);

        assertEquals("Test Case 9 failed.  Method didn't find the coin to be a dime", expected, actual);
    }
    @Test
    public void vendingMachineReadsCoinAsPennyAndRejectsIt() throws Exception{
        String expected = "THIS MACHINE DOES NOT ACCEPT PENNIES";
        String actual = vendingMachine.acceptOrRejectCoin(penny);

        assertEquals("Test Case 10 failed.  Coin was accepted", expected, actual);
    }
    @Test
    public void vendingMachineReadsCoinAsNickelAndAcceptsIt() throws Exception{
        String expected = "NICKEL ACCEPTED";
        String actual = vendingMachine.acceptOrRejectCoin(nickel);

        assertEquals("Test Case 11 failed.  Coin was not accepted", expected, actual);
    }
    @Test
    public void vendingMachineReadsCoinAsDimeAndAcceptsIt() throws Exception{
        String expected = "DIME ACCEPTED";
        String actual = vendingMachine.acceptOrRejectCoin(dime);

        assertEquals("Test Case 12 failed.  Coin was not accepted", expected, actual);
    }
    @Test
    public void vendingMachineReadsCoinAsQuarterAndAcceptsIt() throws Exception{
        String expected = "QUARTER ACCEPTED";
        String actual = vendingMachine.acceptOrRejectCoin(quarter);

        assertEquals("Test Case 13 failed.  Coin was not accepted", expected, actual);
    }
    @Test
    public void vendingMachineRejectsAllOtherCoins() throws Exception{
        Coin junkCoin = new Coin(2.2, 22.21, 1.95, 0);
        String expected = "COIN NOT ACCEPTED";
        String actual = vendingMachine.acceptOrRejectCoin(junkCoin);

        assertEquals("Test Case 14 failed.  Coin was accepted", expected, actual);
    }
    @Test
    public void vendingMachineReturnsInsertCoinBecauseNoValidCoinIsCurrentlyInMachine() throws Exception{
        ArrayList<Coin> insertedCoins = new ArrayList<Coin>();
        String expected = "INSERT COIN";
        String actual = vendingMachine.displayOutput(insertedCoins);

        assertEquals("Test Case 15 failed.  Vending Machine did not display correct output", expected, actual);
    }
    @Test
    public void vendingMachineAcceptsCoinAndReturnsTotalValue() throws Exception{
        ArrayList<Coin> insertedCoins = new ArrayList<Coin>();
        insertedCoins.add(nickel);
        String expected = "total: $0.05";
        String actual = vendingMachine.displayOutput(insertedCoins);

        assertEquals("Test Case 16 failed.  Vending Machine did not display correct output", expected, actual);
    }
    @Test
    public void vendingMachineAcceptsAllCoinsButPenniesAndReturnsTotalValue() throws Exception{
        ArrayList<Coin> insertedCoins = new ArrayList<Coin>();
        insertedCoins.add(nickel);
        insertedCoins.add(dime);
        insertedCoins.add(penny);
        insertedCoins.add(quarter);

        String expected = "total: $0.40";
        String actual = vendingMachine.displayOutput(insertedCoins);

        assertEquals("Test Case 17 failed.  Vending Machine did not display correct output", expected, actual);
    }
    @Test
    public void vendingMachineReturnsInsertCoinAfterRejectingPennyOrJunkCoins() throws Exception{
        Coin junkCoin = new Coin(2.2, 22.21, 1.95, 0);
        ArrayList<Coin> insertedCoins = new ArrayList<Coin>();
        insertedCoins.add(penny);
        insertedCoins.add(junkCoin);
        insertedCoins.add(penny);
        insertedCoins.add(junkCoin);

        String expected = "INSERT COIN";
        String actual = vendingMachine.displayOutput(insertedCoins);

        assertEquals("Test Case 18 failed.  Vending Machine did not display correct output", expected, actual);
    }
    @Test
    public void vendingMachineAllowsConsumerToSelectACola(){
        String expected = "COLA PURCHASED";
        String actual = vendingMachine.selectProduct(VendingMachine.COLA_SELECTED);

        assertEquals("Test Case 19 failed.  Vending machine didn't return a product", expected,actual);
    }
    @Test
    public void vendingMachineAllowsConsumerToSelectChips(){
        String expected = "CHIPS PURCHASED";
        String actual = vendingMachine.selectProduct(VendingMachine.CHIPS_SELECTED);

        assertEquals("Test Case 20 failed.  Vending machine didn't return a product", expected,actual);
    }
    @Test
    public void vendingMachineAllowsConsumerToSelectCandy(){
        String expected = "CANDY PURCHASED";
        String actual = vendingMachine.selectProduct(VendingMachine.CANDY_SELECTED);

        assertEquals("Test Case 21 failed.  Vending machine didn't return a product", expected,actual);
    }

}