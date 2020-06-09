package com.onurtogan.demo.simpleweb.controller;

import com.onurtogan.demo.simpleweb.model.FlightInfo;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class FlightController {

    private List<FlightInfo> flightInfoList = new ArrayList<>();
    private static final String NOT_FOUND_MESSAGE = "Fight not found for number";

    public FlightController() {
        flightInfoList.add(new FlightInfo("Delhi Indira Gandhi", "Stuttgart", "D80"));
        flightInfoList.add(new FlightInfo("Tokio Haneda", "Frankfurt", "110"));
        flightInfoList.add(new FlightInfo("Kilimanjaro Arusha", "Boston", "15"));
        flightInfoList.add(new FlightInfo("Berlin Schönefeld", "Tenerife", "15"));
    }

    @GetMapping("flights/{id}")
    public FlightInfo getFlightInfo(@PathVariable int id) {
        if (id > flightInfoList.size()) {
            throw new FlightNotFoundException("Flight not found for id =" + id);
        }
        return flightInfoList.get(id);
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = NOT_FOUND_MESSAGE)
    public HashMap<String, String> handleNotFoundFlight(Exception e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", NOT_FOUND_MESSAGE);
        response.put("error", e.getClass().getSimpleName());
        return response;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    static class FlightNotFoundException extends RuntimeException {
        public FlightNotFoundException(String s) {
            super(s);
        }
    }
}
