package com.arikko.acme_store.orders;

public class CheckoutDrinkwareProduct extends CheckoutProduct {
    public CheckoutDrinkwareProduct() {
    }

    public CheckoutDrinkwareProduct(String type, int productId, int quantity, String color) {
        super(type, productId, quantity, color);
    }
}
