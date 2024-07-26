package com.emilpiekos.users;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersList {
    private List<User> users = new ArrayList<>(List.of(
            new User("Adam", "Nowak", 22),
            new User("Jan", "Kowalski", 30),
            new User("Kamil", "Szulc", 19)
            ));

    public List<User> getUsers() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }
}
