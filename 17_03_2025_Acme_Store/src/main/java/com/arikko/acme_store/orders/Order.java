package com.arikko.acme_store.orders;

import java.util.ArrayList;

public class Order {
    private int id, userId;
    private ArrayList<CheckoutProduct> products;
    private ShippingDetails shippingDetails;
    private float total;
}
