package com.arikko.acme_store.users;

public class Customer extends User {
    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String email, String password, String phoneNumber) {
        super(id, firstName, lastName, email, password, phoneNumber, "customer");
    }
}
