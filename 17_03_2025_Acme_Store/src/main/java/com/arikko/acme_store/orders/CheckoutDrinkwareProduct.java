package com.arikko.acme_store.orders;

public class CheckoutDrinkwareProduct extends CheckoutProduct {
    public CheckoutDrinkwareProduct() {
    }

    public CheckoutDrinkwareProduct(String type, int productId, int quantity) {
        super(type, productId, quantity);
    }
}
