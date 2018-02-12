package com.pillar.coins;

public class Coin extends CoinAbstract {
    public static final int IS_COIN_A_PENNY = 1;
    public static final int IS_COIN_A_NICKEL = 2;
    public static final int IS_COIN_A_DIME = 3;
    public static final int IS_COIN_A_QUARTER = 4;
    private static Coin penny = null;
    private static Coin nickel = null;
    private static Coin dime = null;
    private static Coin quarter = null;

    private Coin() {
    }
    public Coin(double weight, double width, double thickness, double value, int inventoryQuantity){
        this.weight = weight;
        this.width = width;
        this.thickness = thickness;
        this.value = value;
        this.inventoryQuantity = inventoryQuantity;
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(double weight) {
        super.setWeight(weight);
    }

    @Override
    public double getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public double getThickness() {
        return super.getThickness();
    }

    @Override
    public void setThickness(double thickness) {
        super.setThickness(thickness);
    }

    @Override
    public double getValue() {
        return super.getValue();
    }


    public void setValue(double value) {
        super.setValue(value);
    }

    @Override
    public int getInventoryQuantity() {
        return super.getInventoryQuantity();
    }

    @Override
    public void setInventoryQuantity(int inventoryQuantity) {
        super.setInventoryQuantity(inventoryQuantity);
    }

    public static Coin getPenny(){
        if(penny == null){
            penny = new Coin(2.5,19.5,1.55,.01, 0);
        }
        return penny;
    }

    public static Coin getNickel() {
        if(nickel == null){
          nickel =   new Coin(5.0, 21.21, 1.95, .05, 20);
        }
        return nickel;
    }

    public static Coin getDime() {
        if(dime == null){
            dime = new Coin(2.27, 17.9, 1.35,.10, 20);
        }
        return dime;
    }

    public static Coin getQuarter() {
        if(quarter == null){
            quarter = new Coin(5.67, 24.26, 1.75, .25, 20);
        }
        return quarter;
    }
}
