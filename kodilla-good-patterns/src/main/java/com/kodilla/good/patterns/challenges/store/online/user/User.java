package com.kodilla.good.patterns.challenges.store.online.user;

public class User {

    private String name;
    private String surname;
    private String email;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public String getEmail() {
        return email;
    }
}
