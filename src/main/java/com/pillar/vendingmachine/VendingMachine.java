package com.pillar.vendingmachine;

import com.pillar.coins.Coin;
import com.pillar.product.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class VendingMachine {
    private static DecimalFormat coinFormat = new DecimalFormat("0.00");



    public String getInsertCoinLabel() {
        return "INSERT COIN";
    }

    public boolean isCoinBasedOffWeight(double weight, int coinType) {
        if(coinType == Coin.IS_COIN_A_PENNY){
            return weight == Coin.getPenny().getWeight();
        }
        else if(coinType == Coin.IS_COIN_A_NICKEL){
            return weight == Coin.getNickel().getWeight();
        }
        else if(coinType == Coin.IS_COIN_A_DIME){
            return weight == Coin.getDime().getWeight();
        }
        else if(coinType == Coin.IS_COIN_A_QUARTER){
            return weight == Coin.getQuarter().getWeight();
        }
        return false;

    }

    public boolean isCoinBasedOffWidth(double width, int coinType) {
        if(coinType == Coin.IS_COIN_A_PENNY){
            return width == Coin.getPenny().getWidth();
        }
        else if(coinType == Coin.IS_COIN_A_NICKEL){
            return width == Coin.getNickel().getWidth();
        }
        else if(coinType == Coin.IS_COIN_A_DIME){
            return width == Coin.getDime().getWidth();
        }
        else if(coinType == Coin.IS_COIN_A_QUARTER){
            return width == Coin.getQuarter().getWidth();
        }
        return false;

    }

    public boolean isCoinBasedOffThickness(double thickness, int coinType) {
        if(coinType == Coin.IS_COIN_A_PENNY){
            return thickness == Coin.getPenny().getThickness();
        }
        else if(coinType == Coin.IS_COIN_A_NICKEL){
            return thickness == Coin.getNickel().getThickness();
        }
        else if(coinType == Coin.IS_COIN_A_DIME){
            return thickness == Coin.getDime().getThickness();
        }
        else if(coinType == Coin.IS_COIN_A_QUARTER){
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

    private double acceptedCoinTotal(ArrayList<Coin> insertedCoins){
        double total = 0;
        if(!insertedCoins.isEmpty()){
            for(Coin coin: insertedCoins){
                System.out.println(acceptOrRejectCoin(coin));
                if(!coinTypeChecker(coin, Coin.IS_COIN_A_PENNY)){
                    total += coin.getValue();
                }
            }
        }
        return total;
    }

    public String acceptOrRejectCoin(Coin coin) {
        if(coinTypeChecker(coin,Coin.IS_COIN_A_PENNY)){
            return "THIS MACHINE DOES NOT ACCEPT PENNIES";
        }
        else if(coinTypeChecker(coin,Coin.IS_COIN_A_NICKEL)){
            return "NICKEL ACCEPTED";
        }
        else if(coinTypeChecker(coin,Coin.IS_COIN_A_DIME)){
            return "DIME ACCEPTED";
        }
        else if(coinTypeChecker(coin,Coin.IS_COIN_A_QUARTER)){
            return "QUARTER ACCEPTED";
        }
        return "COIN NOT ACCEPTED";
    }

    public String displayOutput(ArrayList<Coin> insertedCoins) {
       double total = acceptedCoinTotal(insertedCoins);
        if(insertedCoins.isEmpty() || total == 0){
            return getInsertCoinLabel();
        }
        return "total: $" + coinFormat.format(total);

    }

    public String selectProduct(String productSelection) {

        if(productSelection.equals(Product.COLA_SELECTED)){
            return "COLA PURCHASED";
        }
        else if(productSelection.equals(Product.CHIPS_SELECTED)){
            return "CHIPS PURCHASED";
        }
        else if(productSelection.equals(Product.CANDY_SELECTED)){
            return "CANDY PURCHASED";
        }
        return "INVALID SELECTION";
    }

    public String makePurchase(ArrayList<Coin> coins, String productSelected) {
    double total = acceptedCoinTotal(coins);
    Product product = Product.getProductByName(productSelected);

    if(total >= product.getPrice()){
        return "THANK YOU";
    }
    return "PRICE";

    }
    public double returnChange(double totalInserted, double productPrice ){
        if(totalInserted >= productPrice){
            return totalInserted - productPrice;
        }
        return totalInserted;
    }

    public String makeCorrectChange(double returnAmount) {
        String returnString = "RETURNED ";
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        while(returnAmount >= Coin.getQuarter().getValue()){
            quarters += 1;
            returnAmount -= Coin.getQuarter().getValue();
        }
        while(returnAmount >= Coin.getDime().getValue()){
            dimes += 1;
            returnAmount -= Coin.getDime().getValue();
        }
        while(returnAmount >= Coin.getNickel().getValue()){
            nickels += 1;
            returnAmount -= Coin.getNickel().getValue();
        }

        if(quarters > 0){
            if(quarters == 1){
                returnString += quarters + " quarter";
            }
            else{
                returnString += quarters + " quarters";
            }

        }
        if(dimes > 0){
            if(dimes == 1){
                returnString += ", " + dimes + " dime";
            }
            else{
                returnString += ", " + dimes + " dimes";
            }

        }
        if(nickels > 0){
            if(nickels == 1){
                returnString += ", " + nickels + " nickel.";
            }
            else{
                returnString += ", " + nickels + " nickels.";
            }

        }
        return returnString;
    }


    public ArrayList<Coin> returnInsertedCoins(ArrayList<Coin> insertedCoins) {
        double total = acceptedCoinTotal(insertedCoins);
        System.out.println(makeCorrectChange(total));
        return new ArrayList<Coin>();
    }
}
