package com.mehdilagdimi.marocair_api.service;


import com.mehdilagdimi.marocair_api.dao.DaoExecuter;
import com.mehdilagdimi.marocair_api.model.FlightModel;
import com.mehdilagdimi.marocair_api.model.entity.Flight;
import jakarta.inject.Inject;

import java.util.List;

public class FlightService {

    @Inject
    DaoExecuter<Flight> flightDaoExecuter;

    public String helloFromFlighService(){
        return "hello from flight service";
    }

    public List<Flight> getAllFlights(){
        return flightDaoExecuter.getAll(Flight.class);
    }
    public List<Flight> addFlight(FlightModel flightModel){
        return null;
    }
}
