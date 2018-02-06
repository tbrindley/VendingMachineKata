package com.pillar.coins;

public class Coin extends CoinAbstract {
    public Coin() {
    }
    public Coin(double weight, double width, double thickness, double value){
        this.weight = weight;
        this.width = width;
        this.thickness = thickness;
        this.value = value;
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

    @Override
    public void setValue(double value) {
        super.setValue(value);
    }

    public static Coin getPenny(){
        Coin penny = new Coin(2.5,19.5,1.55,.01);
        return penny;
    }

    public static Coin getNickel() {
        Coin nickel = new Coin(5.0, 21.21, 1.95, .05);
        return nickel;
    }
}
