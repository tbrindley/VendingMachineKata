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
        return weight == Coin.getPenny().getWeight();
    }

    public boolean isCoinBasedOffWidth(double width) {
       return width == Coin.getPenny().getWidth();
    }

    public boolean isCoinBasedOffThickness(double thickness) {
        return thickness == Coin.getPenny().getThickness();

    }

    public boolean isCoinAPenny(Coin potentialPenny) {
        vendingMachine = new VendingMachine();
        boolean hasPennyWeight = vendingMachine.isCoinBasedOffWeight(potentialPenny.getWeight());
        boolean hasPennyWidth = vendingMachine.isCoinBasedOffWidth(potentialPenny.getWidth());
        boolean hasPennyThickness = vendingMachine.isCoinBasedOffThickness(potentialPenny.getThickness());

        return hasPennyWeight && hasPennyWidth && hasPennyThickness;

    }
}
