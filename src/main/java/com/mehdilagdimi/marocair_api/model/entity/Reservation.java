package com.mehdilagdimi.marocair_api.model.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Timestamp created_at = Timestamp.from(Instant.now());
    float amount;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) @JoinColumn(name = "client_id", referencedColumnName = "id")
    Client client;

    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Passenger> passengers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) @JoinColumn(name = "flight_id", referencedColumnName = "id")
    Flight flight;

    public Reservation () {

    }

    public Reservation(Client client, Flight flight, Timestamp created_at, float amount) {
        this.client = client;
        this.flight = flight;
        this.created_at = created_at;
        this.amount = amount;
    }
    public Reservation(int id, Client client,  Flight flight, Timestamp created_at, float amount) {
        this.id = id;
        this.client = client;
        this.flight = flight;
        this.created_at = created_at;
        this.amount = amount;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }



    public static Map<String, String> typesToMap () {
        Reservation reservationObj = new Reservation();
        Map<String, String> typesMap = new LinkedHashMap<>();

        typesMap.put("id", ((Object) reservationObj.id).getClass().getSimpleName());
        typesMap.put("client", ((Object) reservationObj.client).getClass().getSimpleName());
        typesMap.put("flight", ((Object) reservationObj.flight).getClass().getSimpleName());
        typesMap.put("created_at", ((Object) reservationObj.created_at).getClass().getSimpleName());
        typesMap.put("amount", ((Object) reservationObj.amount).getClass().getSimpleName());
        return typesMap;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", client=" + client +
                ", flight_id=" + flight +
                ", created_at=" + created_at +
                ", amount=" + amount +
                ", flight=" + flight +
                '}';
    }
}
