package com.arikko.acme_store.users;

import java.util.ArrayList;

public class Customer extends User {
    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String email, String password, String phoneNumber) {
        super(id, firstName, lastName, email, password, phoneNumber, "customer");
    }

    public static int generateCustomerId(ArrayList<User> users) {
        int lastUserId = users.getLast().getId();
        return lastUserId + 1;
    }
}
