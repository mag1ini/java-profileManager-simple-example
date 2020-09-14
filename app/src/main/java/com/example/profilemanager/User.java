package com.example.profilemanager;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {

    public String Firstname;
    public String Lastname;
    public String Phone;
    public String City;

    public User(String firstname, String lastname, String phone, String city) {
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.Phone = phone;
        this.City = city;
    }

}
