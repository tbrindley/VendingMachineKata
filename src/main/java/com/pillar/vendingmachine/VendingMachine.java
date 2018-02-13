package com.pillar.vendingmachine;

import com.pillar.coins.Coin;
import com.pillar.product.Product;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class VendingMachine {
    private static DecimalFormat coinFormat = new DecimalFormat("0.00");
    private static final int QUARTER = 0;
    private static final int DIME = 1;
    private static final int NICKEL = 2;

    /**
     * @param weight is the double value of the prospective coin.  Just use the getWeight attribute for the Coin object you're comparing
     * @param coinType is the static int from the Coin class.  1 = penny, 2 = nickel, 3 = dime, 4 = quarter
     * @return true if weight matches weight of selected coin
     */
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

    /**
     * @param width is the double value of the prospective coin.  Just use the getWidth attribute for the Coin object you're comparing
     * @param coinType is the static int from the Coin class.  1 = penny, 2 = nickel, 3 = dime, 4 = quarter
     * @return true if width matches weight of selected coin
     */
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

    /**
     * @param thickness is the double value of the prospective coin.  Just use the getThickness attribute for the Coin object you're comparing
     * @param coinType is the static int from the Coin class.  1 = penny, 2 = nickel, 3 = dime, 4 = quarter
     * @return true if thickness matches weight of selected coin
     */
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

    /**
     * @param potentialCoin is the Coin object you want to compare against a coin type.
     * @param coinType is the static int from the Coin class.  1 = penny, 2 = nickel, 3 = dime, 4 = quarter
     * @return true if Coin objects weight, width, and thickness all match the selected coin type.
     */
    public boolean coinTypeChecker(Coin potentialCoin, int coinType) {
        VendingMachine vendingMachine = new VendingMachine();
        boolean matchesWeight = vendingMachine.isCoinBasedOffWeight(potentialCoin.getWeight(), coinType);
        boolean matchesWidth = vendingMachine.isCoinBasedOffWidth(potentialCoin.getWidth(), coinType);
        boolean matchesThickness = vendingMachine.isCoinBasedOffThickness(potentialCoin.getThickness(), coinType);

        return matchesWeight && matchesWidth && matchesThickness;
    }

    /**
     * @param insertedCoins is an ArrayList of all potential coins.
     * @return total value of all accepted coins 'no pennies' as a double
     */
    private double acceptedCoinTotal(ArrayList<Coin> insertedCoins){
        double total = 0;
        if(!insertedCoins.isEmpty()){
            for(Coin coin: insertedCoins){
                if(!coinTypeChecker(coin, Coin.IS_COIN_A_PENNY)){
                    total += coin.getValue();
                }
            }
        }
        return total;
    }

    public String getInsertCoinLabel() {
        return "INSERT COIN";
    }

    /**
     * @param coin 'Coin object'
     * @return Accepted or Rejected string based on coin type
     */
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

    /**
     * @param insertedCoins is an ArrayList of all coins inserted into the machine.
     * @return String value representing value of all coins inserted into machine.
     */
    public String displayOutput(ArrayList<Coin> insertedCoins) {
       double total = acceptedCoinTotal(insertedCoins);
        if(insertedCoins.isEmpty() || total == 0){
            return getInsertCoinLabel();
        }
        return "total: $" + coinFormat.format(total);

    }

    /**
     * @param productSelection has a static String in the Product class that can be used in this method.
     * @return String showing machine output based off purchase
     */
    public String selectProduct(String productSelection) {
        if(hasInventory(productSelection)){
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
        return "SOLD OUT";
    }

    /**
     * @param coins is an ArrayList representing all inserted coins into the vending machine
     * @param productSelected has a static String in the Product class that can be used in this method.
     * @return String showing Vending Machine output when a purchase is attempted
     */
    public String makePurchase(ArrayList<Coin> coins, String productSelected) {
    double total = acceptedCoinTotal(coins);
    Product product = Product.getProductByName(productSelected);
    if(total >= product.getPrice() && !exactChangeOnly(coins, product.getName())){
        System.out.println(makeCorrectChange(returnChange(total, product.getPrice())));
        coins.clear();
        return "THANK YOU";
    }
    else if(exactChangeOnly(coins, product.getName())){
        return "EXACT CHANGE ONLY";
    }
    return "PRICE";

    }

    public double returnChange(double totalInserted, double productPrice ){
        if(totalInserted >= productPrice){
            return totalInserted - productPrice;
        }
        return totalInserted;
    }

    /**
     * @param returnAmount is the dollar amount that needs to be returned to the consumer
     * @return String value representing exact change being returned
     */
    public String makeCorrectChange(double returnAmount) {
        String returnString = "RETURNED ";
        int[] coinCount = getCoinTypeCount(returnAmount);
        int quarters = coinCount[QUARTER];
        int dimes = coinCount[DIME];
        int nickels = coinCount[NICKEL];
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

        if(quarters + dimes + nickels == 0){
            returnString = "";
        }
        return returnString;
    }

    /**
     * @param insertedCoins represents all coins inserted into vending machine
     * @return Returns cleared ArrayList representing no coins inserted into machine.
     */
    public ArrayList<Coin> returnInsertedCoins(ArrayList<Coin> insertedCoins) {
        insertedCoins.clear();
        return insertedCoins;
    }

    /**
     * @return method returns true if there is at least 1 of the selected product in inventory.
     */
    public boolean hasInventory(String selection){
        return Product.getProductByName(selection).getQuantityInStock() > 0;
    }

    /**
     * @return method returns true if the vending machine needs to return more of a specific coin than it has in inventory.
     * will also place coins back into inventory if exact change to represent no coins being dispensed.
     */
    public boolean exactChangeOnly(ArrayList<Coin> coins, String selection) {
        double totalInserted = acceptedCoinTotal(coins);

        Product product = Product.getProductByName(selection);
        double change = returnChange(totalInserted, product.getPrice());
        int[] coinCount = getCoinTypeCount(change);
        if(coinCount[QUARTER] > Coin.getQuarter().getInventoryQuantity() ||
                coinCount[DIME] > Coin.getDime().getInventoryQuantity() ||
                coinCount[NICKEL] > Coin.getDime().getInventoryQuantity()){

            //puts coins back into inventory
            Coin.getQuarter().setInventoryQuantity(coinCount[QUARTER]);
            Coin.getDime().setInventoryQuantity(coinCount[DIME]);
            Coin.getNickel().setInventoryQuantity(coinCount[NICKEL]);
            return true;
        }
        return false;
    }

    /**
     * @return method returns the count of each coin to be returned to the consumer.  index 0 = quarter, 1 = dime, 2 = nickel
     */
    private int[] getCoinTypeCount(double changeToBeReturned) {
        int coinCount[] = new int[3];
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        while(changeToBeReturned >= Coin.getQuarter().getValue()){
            quarters += 1;
            Coin.getQuarter().removeOneCoinFromInventory();
            changeToBeReturned -= Coin.getQuarter().getValue();
        }
        while(changeToBeReturned >= Coin.getDime().getValue()){
            dimes += 1;
            Coin.getDime().removeOneCoinFromInventory();
            changeToBeReturned -= Coin.getDime().getValue();
        }
        while(changeToBeReturned >= Coin.getNickel().getValue()){
            nickels += 1;
            Coin.getNickel().removeOneCoinFromInventory();
            changeToBeReturned -= Coin.getNickel().getValue();
        }
        coinCount[QUARTER] = quarters;
        coinCount[DIME] = dimes;
        coinCount[NICKEL] = nickels;
        return coinCount;
    }
}
