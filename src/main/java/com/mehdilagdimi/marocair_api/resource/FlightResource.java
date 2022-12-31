package com.mehdilagdimi.marocair_api.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.google.gson.JsonObject;
import com.mehdilagdimi.marocair_api.base.ObjectMapperFactory;
import com.mehdilagdimi.marocair_api.model.FlightModel;
import com.mehdilagdimi.marocair_api.model.entity.Flight;
import com.mehdilagdimi.marocair_api.service.FlightService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.JSONP;

import java.io.IOException;
import java.util.List;

@Path("/flights")
public class FlightResource {

    @Inject
    FlightService flightService;

//    @Inject
//    ObjectMapperFactory objectMapperFactory;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return Response
                .status(Response.Status.OK)
                .entity(flights)
                .build();
    }

    @GET
    @Path(value = "{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlight(@PathParam("id") int id) {
        Flight flight = flightService.getFlightById(id);
        System.out.println(" flight " + flight);
        return Response
                .status(flight != null ? Response.Status.OK : Response.Status.INTERNAL_SERVER_ERROR)
                .entity(flight)
                .build();
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFlight(FlightModel flightModel) {
        Flight flight;
        ObjectMapper objectMapper = new ObjectMapper();
        flight = flightService.addFlight(flightModel);

        return Response
                .status(flight != null ? Response.Status.OK : Response.Status.INTERNAL_SERVER_ERROR)
                .entity(flight)
                .build();
    }


}