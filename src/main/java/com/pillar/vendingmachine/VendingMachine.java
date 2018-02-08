package com.pillar.vendingmachine;

import com.pillar.coins.Coin;

/**
 * Created by Travis Brindley on 2/6/2018.
 */
public class VendingMachine {
    private VendingMachine vendingMachine;

    public String getInsertCoinLabel() {
        return "INSERT COIN";
    }

    public boolean isCoinBasedOffWeight(double weight) {
        if(weight == Coin.getPenny().getWeight()){
            return true;
        }
        return false;
    }

    public boolean isCoinBasedOffWidth(double width) {
        if(width == Coin.getPenny().getWidth()){
            return true;
        }
        return false;
    }

    public boolean isCoinBasedOffThickness(double thickness) {
        if(thickness == Coin.getPenny().getThickness()){
            return true;
        }
        return false;
    }

    public boolean isCoinAPenny(Coin potentialPenny) {
        vendingMachine = new VendingMachine();
        boolean hasPennyWeight = vendingMachine.isCoinBasedOffWeight(potentialPenny.getWeight());
        boolean hasPennyWidth = vendingMachine.isCoinBasedOffWidth(potentialPenny.getWidth());
        boolean hasPennyThickness = vendingMachine.isCoinBasedOffThickness(potentialPenny.getThickness());

        return hasPennyWeight && hasPennyWidth && hasPennyThickness;

    }
}
