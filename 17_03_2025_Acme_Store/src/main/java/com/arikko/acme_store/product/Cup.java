package com.arikko.acme_store.product;

import java.util.ArrayList;

public class Cup extends DrinkwareProduct{
    public Cup() {
    }

    public Cup(int id, String name, String description, String type, ArrayList<String> colors, int quantity, float price) {
        super(id, name, description, type, colors, quantity, price, "cup");
    }
}
