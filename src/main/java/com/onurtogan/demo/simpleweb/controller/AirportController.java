package com.onurtogan.demo.simpleweb.controller;

import com.onurtogan.demo.simpleweb.model.AirportInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AirportController {

    private List<AirportInfo> airportInfoList = new ArrayList<>();

    public AirportController() {
        airportInfoList.add(new AirportInfo("Berlin Teggel", "TXL", "EDDT"));
        airportInfoList.add(new AirportInfo("Berlin Schönefeld", "SXF", "EDDB"));
    }

    @GetMapping("airports/{id}")
    public AirportInfo getAirportInfo(@PathVariable int id) {
        return airportInfoList.get(id);
    }
}
