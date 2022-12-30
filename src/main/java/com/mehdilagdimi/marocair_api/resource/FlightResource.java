package com.mehdilagdimi.marocair_api.resource;

import com.mehdilagdimi.marocair_api.model.FlightModel;
import com.mehdilagdimi.marocair_api.model.entity.Flight;
import com.mehdilagdimi.marocair_api.service.FlightService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/flights")
public class FlightResource {

    @Inject
    FlightService flightService;

    @GET
//    @Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }

    @GET
    @Path(value = "{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlight(@PathParam("id") long id) {
        return Response.ok("Hello, World!").build();
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFlight(@BeanParam FlightModel flightModel) {

        return Response.ok("Flight added!").build();
    }


}