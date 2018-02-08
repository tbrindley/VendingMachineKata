package com.pillar.vendingmachine;

import com.pillar.coins.Coin;

/**
 * Created by Travis Brindley on 2/6/2018.
 */
public class VendingMachine {
    public static int IS_COIN_A_PENNY = 1;
    public static int IS_COIN_A_NICKEL = 2;

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
        return false;

    }

    public boolean isCoinBasedOffWidth(double width, int coinType) {
        if(coinType == IS_COIN_A_PENNY){
            return width == Coin.getPenny().getWidth();
        }
        else if(coinType == IS_COIN_A_NICKEL){
            return width == Coin.getNickel().getWidth();
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
        return false;


    }

    public boolean coinTypeChecker(Coin potentialCoin, int coinType) {
        VendingMachine vendingMachine = new VendingMachine();
        boolean matchesWeight = vendingMachine.isCoinBasedOffWeight(potentialCoin.getWeight(), coinType);
        boolean matchesWidth = vendingMachine.isCoinBasedOffWidth(potentialCoin.getWidth(), coinType);
        boolean matchesThickness = vendingMachine.isCoinBasedOffThickness(potentialCoin.getThickness(), coinType);

        return matchesWeight && matchesWidth && matchesThickness;

    }


}
