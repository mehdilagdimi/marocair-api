package com.mehdilagdimi.marocair_api.model.entity;


import com.mehdilagdimi.marocair_api.base.Person;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Client extends Person {

    @Column(nullable = false)
    @Basic(optional = false)
    private int code;

    @Column(nullable = false)
    @Basic(optional = false)
    private String phone;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Passenger> passengers = new ArrayList<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    List<Reservation> reservations = new ArrayList<>();

    public Client() {

    }

    public Client(int id, String fullname, String email, String phone, int code, String password) {
        super(id, fullname, email, password);
        this.code = code;
        this.phone = phone;
    }

    public Client(String fullname, String email, String phone, int code, String password) {
        super(fullname, email, password);
        this.code = code;
        this.phone = phone;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
