package main.java.gojek.model;

public class Bank {
    User user;

    public Bank() {
        this.user = new User();
    }

    public User getUser() {
        return this.user;
    }
}
