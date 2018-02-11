package com.pillar.vendingmachine;

import com.pillar.coins.Coin;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class VendingMachine {
    private static DecimalFormat coinFormat = new DecimalFormat("0.00");
    public static final int IS_COIN_A_PENNY = 1;
    public static final int IS_COIN_A_NICKEL = 2;
    public static final int IS_COIN_A_DIME = 3;
    public static final int IS_COIN_A_QUARTER = 4;
    public static final String COLA_SELECTED = "cola";
    public static final String CHIPS_SELECTED = "chips";
    public static final String CANDY_SELECTED = "candy";

    public String getInsertCoinLabel() {
        return "INSERT COIN";
    }

    public boolean isCoinBasedOffWeight(double weight, int coinType) {
        if(coinType == IS_COIN_A_PENNY){
            return weight == Coin.getPenny().getWeight();
        }
        else if(coinType == IS_COIN_A_NICKEL){
            return weight == Coin.getNickel().getWeight();
        }
        else if(coinType == IS_COIN_A_DIME){
            return weight == Coin.getDime().getWeight();
        }
        else if(coinType == IS_COIN_A_QUARTER){
            return weight == Coin.getQuarter().getWeight();
        }
        return false;

    }

    public boolean isCoinBasedOffWidth(double width, int coinType) {
        if(coinType == IS_COIN_A_PENNY){
            return width == Coin.getPenny().getWidth();
        }
        else if(coinType == IS_COIN_A_NICKEL){
            return width == Coin.getNickel().getWidth();
        }
        else if(coinType == IS_COIN_A_DIME){
            return width == Coin.getDime().getWidth();
        }
        else if(coinType == IS_COIN_A_QUARTER){
            return width == Coin.getQuarter().getWidth();
        }
        return false;

    }

    public boolean isCoinBasedOffThickness(double thickness, int coinType) {
        if(coinType == IS_COIN_A_PENNY){
            return thickness == Coin.getPenny().getThickness();
        }
        else if(coinType == IS_COIN_A_NICKEL){
            return thickness == Coin.getNickel().getThickness();
        }
        else if(coinType == IS_COIN_A_DIME){
            return thickness == Coin.getDime().getThickness();
        }
        else if(coinType == IS_COIN_A_QUARTER){
            return thickness == Coin.getQuarter().getThickness();
        }
        return false;


    }

    public boolean coinTypeChecker(Coin potentialCoin, int coinType) {
        VendingMachine vendingMachine = new VendingMachine();
        boolean matchesWeight = vendingMachine.isCoinBasedOffWeight(potentialCoin.getWeight(), coinType);
        boolean matchesWidth = vendingMachine.isCoinBasedOffWidth(potentialCoin.getWidth(), coinType);
        boolean matchesThickness = vendingMachine.isCoinBasedOffThickness(potentialCoin.getThickness(), coinType);

        return matchesWeight && matchesWidth && matchesThickness;

    }

    public String acceptOrRejectCoin(Coin coin) {
        if(coinTypeChecker(coin,IS_COIN_A_PENNY)){
            return "THIS MACHINE DOES NOT ACCEPT PENNIES";
        }
        else if(coinTypeChecker(coin,IS_COIN_A_NICKEL)){
            return "NICKEL ACCEPTED";
        }
        else if(coinTypeChecker(coin,IS_COIN_A_DIME)){
            return "DIME ACCEPTED";
        }
        else if(coinTypeChecker(coin,IS_COIN_A_QUARTER)){
            return "QUARTER ACCEPTED";
        }
        return "COIN NOT ACCEPTED";
    }

    public String displayOutput(ArrayList<Coin> insertedCoins) {
        double total = 0;
        if(!insertedCoins.isEmpty()){
            for(Coin coin: insertedCoins){
                System.out.println(acceptOrRejectCoin(coin));
                if(!coinTypeChecker(coin, IS_COIN_A_PENNY)){
                    total += coin.getValue();
                }
            }
        }
        if(insertedCoins.isEmpty() || total == 0){
            return getInsertCoinLabel();
        }
        return "total: $" + coinFormat.format(total);

    }

    public String selectProduct(String productSelection) {

        if(productSelection.equals(COLA_SELECTED)){
            return "COLA PURCHASED";
        }
        else if(productSelection.equals(CHIPS_SELECTED)){
            return "CHIPS PURCHASED";
        }
        else if(productSelection.equals(CANDY_SELECTED)){
            return "CANDY PURCHASED";
        }
        return "INVALID SELECTION";
    }
}
