package com.arikko.acme_store.users;

public class Customer extends User {
    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String email, String password, String phoneNumber, String type) {
        super(id, firstName, lastName, email, password, phoneNumber, type);
    }
}
