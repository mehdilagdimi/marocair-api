package com.mehdilagdimi.marocair_api.entity;

import com.mehdilagdimi.marocair_api.base.Person;

public class Admin extends Person {

    public Admin() {

    }

    public Admin(int id, String fullname, String email, String phone, String password) {
        super(id, fullname, email,password);
    }

    public Admin(String fullname, String email, String phone, String password) {
        super(fullname, email, password);
    }
}
