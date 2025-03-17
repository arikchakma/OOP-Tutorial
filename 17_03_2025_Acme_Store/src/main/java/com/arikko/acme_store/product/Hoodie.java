package com.arikko.acme_store.product;

import java.util.ArrayList;

public class Hoodie extends ApparelProduct {
    public Hoodie() {
    }

    public Hoodie(int id, String name, String description, String type, ArrayList<String> colors, int quantity, float price, ArrayList<String> sizes, String material) {
        super(id, name, description, type, colors, quantity, price, sizes, material);
    }
}
