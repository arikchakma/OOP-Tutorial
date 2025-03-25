package com.arikko.acme_store.users;

import java.util.ArrayList;
import java.util.Random;

public class Customer extends User {
    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String email, String password, String phoneNumber) {
        super(id, firstName, lastName, email, password, phoneNumber, "customer");
    }

    public static int generateCustomerId(ArrayList<User> users) {
        Random rd = new Random();
        int lastUserId = rd.nextInt(1000, 10000);
        if (!users.isEmpty()) {
            User lastUser = users.getLast();
            lastUserId = lastUser.getId() + 1;
        }

        return lastUserId;
    }
}
