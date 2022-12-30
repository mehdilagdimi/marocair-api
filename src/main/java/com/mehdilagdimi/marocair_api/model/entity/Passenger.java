package com.mehdilagdimi.marocair_api.model.entity;

import com.mehdilagdimi.marocair_api.base.Person;
import jakarta.persistence.*;



@Entity
public class Passenger  extends Person {

    private String fullname;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    Client client;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
            @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    Reservation reservation;

    public Passenger(){

    }
    public Passenger(int id, String fullname, Reservation reservation) {
        this.id = id;
        this.fullname = fullname;
        this.reservation = reservation;
    }

    public Passenger(String fullname, Reservation reservation) {
        this.fullname = fullname;
        this.reservation = reservation;
    }

    public String getFullname() {
        return fullname;
    }


    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }


}
