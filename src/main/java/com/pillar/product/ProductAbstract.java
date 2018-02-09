package com.pillar.product;

/**
 * Created by Travis Brindley on 2/8/2018.
 */
abstract class ProductAbstract {
    double price;
    int quantityInStock;
    String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
