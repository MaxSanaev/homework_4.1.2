package com.example.homework_412;

public class User {
    private String family, name, fatherName, email;
    private int id;

    public User(String family, String name, String fatherName, String email) {
        this.family = family;
        this.name = name;
        this.fatherName = fatherName;
        this.email = email;
        this.id = -1;
    }

    public int save() {
        this.id = 5790;
        return this.id;
    }
}
