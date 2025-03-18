package com.arikko.acme_store.users;

public class Admin extends User {
    public Admin() {
    }

    public Admin(int id, String firstName, String lastName, String email, String password, String phoneNumber) {
        super(id, firstName, lastName, email, password, phoneNumber, "admin");
    }
}
