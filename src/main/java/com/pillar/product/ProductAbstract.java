package com.pillar.product;

abstract class ProductAbstract {
    double price;
    int quantityInStock;
    String name;

    public double getPrice() {
        return price;
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
}
