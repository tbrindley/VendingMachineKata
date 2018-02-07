package com.pillar;

import com.pillar.vendingmachine.VendingMachine;

/**
 * Created by Travis Brindley on 2/6/2018.
 */
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        System.out.println(vendingMachine.getInsertCoinLabel());
    }
}
