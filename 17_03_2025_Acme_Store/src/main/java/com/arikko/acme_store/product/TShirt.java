package com.arikko.acme_store.product;

import java.util.ArrayList;

public class TShirt extends ApparelProduct {
    public TShirt() {
    }

    public TShirt(int id, String name, String description, String type, ArrayList<String> colors, int quantity, float price, ArrayList<String> sizes, String material) {
        super(id, name, description, type, colors, quantity, price, sizes, material);
    }
}
