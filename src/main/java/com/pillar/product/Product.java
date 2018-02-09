package com.pillar.product;

/**
 * Created by Travis Brindley on 2/8/2018.
 */
public class Product extends ProductAbstract {

    public Product() {
    }

    public Product(double price, int quantityInStock, String productName){
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.name = productName;
    }
    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public int getQuantityInStock() {
        return super.getQuantityInStock();
    }

    @Override
    public void setQuantityInStock(int quantityInStock) {
        super.setQuantityInStock(quantityInStock);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public static Product getCola() {
        return new Product(1.00, 10, "Cola");
    }
}
