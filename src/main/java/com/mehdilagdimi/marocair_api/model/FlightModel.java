package com.mehdilagdimi.marocair_api.model;


import jakarta.ws.rs.FormParam;

public class FlightModel {

    @FormParam("_from")
    private String _from;

    @FormParam("_to")
    private String _to;

    @FormParam("nbrOfSeats")
    private int nbrOfSeats;


    @FormParam("departTime")
    private String departTime;

    @FormParam("arrivalTime")
    private String arrivalTime;

    @FormParam("price")
    private float price;

    @FormParam("parentId")
    private long parent_id;
}
