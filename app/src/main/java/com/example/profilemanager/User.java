package com.example.profilemanager;

import java.io.Serializable;

public class User implements Serializable {
    String Firstname;

    public User(String firstname) {
        this.Firstname = firstname;
    }
}
