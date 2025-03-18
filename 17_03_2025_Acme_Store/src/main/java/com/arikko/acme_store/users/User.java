package com.arikko.acme_store.users;

import java.util.ArrayList;

public abstract class User {
    private int id;
    private String firstName, lastName, email, password;
    private String phoneNumber; // +8801xxx
    private String type; // customer, admin

    public User() {
    }

    public User(int id, String firstName, String lastName, String email, String password, String phoneNumber, String type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static User verifyUser(ArrayList<User> users, String email, String password) {
        User currUser = null;
        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                currUser = u;
                break;
            }
        }

        return currUser;
    }

    public static boolean validateEmailAndPassword(String email, String pwd) {
        if (!email.contains("@")) {
            return false;
        }

        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        boolean hasNumber = false;
        for (String number : numbers) {
            if (pwd.contains(number)) {
                hasNumber = true;
                break;
            }
        }

        return hasNumber && pwd.length() >= 6;
    }
}
