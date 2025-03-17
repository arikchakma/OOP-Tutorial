package com.arikko.acme_store.product;

import java.util.ArrayList;

public abstract class DrinkwareProduct extends Product {
    public DrinkwareProduct() {
    }

    public DrinkwareProduct(int id, String name, String description, String type, ArrayList<String> colors, int quantity, float price) {
        super(id, name, description, type, colors, quantity, price);
    }
}
