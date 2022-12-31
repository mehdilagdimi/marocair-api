package com.mehdilagdimi.marocair_api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.ws.rs.FormParam;
import lombok.*;


public class FlightModel {

//    @FormParam("_from")
    private String _from;

//    @FormParam("_to")
    private String _to;

//    @FormParam("nbrOfSeats")
    private int nbrOfSeats;


//    @FormParam("departTime")
    private String departTime;

//    @FormParam("arrivalTime")
    private String arrivalTime;

//    @FormParam("price")
    private float price;

//    @FormParam("parentId")
    private Integer parent_id;

    @JsonCreator
    public FlightModel(
            @JsonProperty("_from") String _from,
            @JsonProperty("_to") String _to,
            @JsonProperty("nbrOfSeats") int nbrOfSeats,
            @JsonProperty("departTime")  String departTime,
            @JsonProperty("arrivalTime") String arrivalTime,
            @JsonProperty("price")  float price,
            @JsonProperty("parent_id") Integer parent_id) {
        this._from = _from;
        this._to = _to;
        this.nbrOfSeats = nbrOfSeats;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.parent_id = parent_id;
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

    public int getNbrOfSeats() {
        return nbrOfSeats;
    }

    public void setNbrOfSeats(int nbrOfSeats) {
        this.nbrOfSeats = nbrOfSeats;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }
}
