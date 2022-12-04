package com.mehdilagdimi.marocair_api.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flight {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String _from;

    @Basic(optional = false)
    @Column(nullable = false)
    private String _to;
    private int nbrOfSeats;
    private int availableSeats;

    private Timestamp departTime;
    private Timestamp arrivalTime;

    private Timestamp created_at = Timestamp.from(Instant.now());
    private float price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Flight parent = null;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    List<Flight> itinerariesFlights = new ArrayList<>();

    public Flight() {
    }

    public Flight(int id, String _from, String _to, int nbrOfSeats, int availableSeats, Timestamp departTime, Timestamp arrivalTime,float price) {
        this.id = id;
        this._from = _from;
        this._to = _to;
        this.nbrOfSeats = nbrOfSeats;
        this.availableSeats = availableSeats;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }


    public Flight(String _from, String _to, int nbrOfSeats, int availableSeats, Timestamp departTime, Timestamp arrivalTime, float price) {
        this._from = _from;
        this._to = _to;
        this.nbrOfSeats = nbrOfSeats;
        this.availableSeats = availableSeats;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String get_from() {
        return _from;
    }

    public void set_from(String _from) {
        this._from = _from;
    }

    public String get_to() {
        return _to;
    }

    public void set_to(String _to) {
        this._to = _to;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Flight getParent() {
        return parent;
    }

    public void setParent(Flight parent) {
        this.parent = parent;
    }

    public List<Flight> getItinerariesFlights() {
        return itinerariesFlights;
    }

    public void setItinerariesFlights(List<Flight> itinerariesFlights) {
        this.itinerariesFlights = itinerariesFlights;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getNbrOfSeats() {
        return nbrOfSeats;
    }

    public void setNbrOfSeats(int nbrOfSeats) {
        this.nbrOfSeats = nbrOfSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Timestamp getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Timestamp departTime) {
        this.departTime = departTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", _from='" + _from + '\'' +
                ", _to='" + _to + '\'' +
                ", nbrOfSeats=" + nbrOfSeats +
                ", availableSeats=" + availableSeats +
                ", departTime=" + departTime +
                ", arrivalTime=" + arrivalTime +
                ", price=" + price +
                '}';
    }
}
