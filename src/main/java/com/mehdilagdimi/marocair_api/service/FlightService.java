package com.mehdilagdimi.marocair_api.service;


import com.mehdilagdimi.marocair_api.dao.DaoExecuter;
import com.mehdilagdimi.marocair_api.model.FlightModel;
import com.mehdilagdimi.marocair_api.model.entity.Flight;
import com.mehdilagdimi.marocair_api.util.TimeHelper.TimeUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@ApplicationScoped
public class FlightService {

    @Inject
    DaoExecuter<Flight> flightDaoExecuter;

    public String helloFromFlighService(){
        return "hello from flight service";
    }

    public List<Flight> getAllFlights(){
        return flightDaoExecuter.getAll(Flight.class);
    }
    public Flight getFlightById(int id){
        return flightDaoExecuter.find(id, Flight.class);
    }
    public Flight addFlight(FlightModel model){
        Flight flight = new Flight(
                model.get_from(),
                model.get_to(),
                model.getNbrOfSeats(),
                TimeUtil.stringToTimestamp(model.getDepartTime()),
                TimeUtil.stringToTimestamp(model.getArrivalTime()),
                model.getPrice()
        );
        Flight parent = model.getParent_id() != null ? flightDaoExecuter.find(model.getParent_id(), Flight.class) : null;
        flight.setParent(parent);
        flightDaoExecuter.save(flight);
        return flight;
    }
}
