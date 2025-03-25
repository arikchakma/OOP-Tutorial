package com.arikko.acme_store.product;

import java.util.ArrayList;

public abstract class DrinkwareProduct extends Product {
    private String type; // cup

    public DrinkwareProduct() {
    }

    public DrinkwareProduct(int id, String name, String description, String productType, ArrayList<String> colors, int quantity, float price, String type) {
        super(id, name, description, productType, colors, quantity, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DrinkwareProduct{" +
                "type='" + type + '\'' +
                '}';
    }
}
