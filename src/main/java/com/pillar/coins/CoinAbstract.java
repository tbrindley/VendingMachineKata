package com.pillar.coins;


abstract class CoinAbstract {
    double weight;
    double width ;
    double thickness;
    double value;
    int inventoryQuantity;

    public double getWeight() {
        return weight;
    }

    public double getWidth() {
        return width;
    }

    public double getThickness() {
        return thickness;
    }

    public double getValue() {
        return value;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }
}
