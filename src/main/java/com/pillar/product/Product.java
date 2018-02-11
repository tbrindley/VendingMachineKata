package com.pillar.product;

/**
 * Created by Travis Brindley on 2/8/2018.
 */
public class Product extends ProductAbstract {
    public static final String COLA_SELECTED = getCola().getName();
    public static final String CHIPS_SELECTED = getChips().getName();
    public static final String CANDY_SELECTED = getCandy().getName();

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

    public static Product getChips() {
        return new Product(0.50, 13, "Chips");
    }

    public static Product getCandy() {
        return new Product(0.65, 15, "Candy");
    }

    public static Product getProductByName(String productName){
        if(productName.equals(COLA_SELECTED)){
            return getCola();
        }
        else if(productName.equals(CHIPS_SELECTED)){
            return getChips();
        }
        else if(productName.equals(CANDY_SELECTED)){
            return getCandy();
        }
        return null;
    }
}
