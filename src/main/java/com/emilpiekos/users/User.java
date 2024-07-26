package com.emilpiekos.users;

import org.springframework.web.bind.annotation.RequestParam;

public class User {
    private final String firstName;
    private final String lastName;
    private final int age;

    public User(String firstName,
                @RequestParam String lastName,
                @RequestParam int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", age: " + age;
    }
}
