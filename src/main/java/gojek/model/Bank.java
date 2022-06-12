package main.java.gojek.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<User> users;

    public Bank(int numberOfUsers) {
        this.users = new ArrayList<>();
        for(int i=0;i<numberOfUsers;i++){
            users.add(new User(i));
        }
    }

    public User getUser(int userId) {
        return users.get(userId);
    }
}
