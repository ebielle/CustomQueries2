package com.example.custom_queries2.controllers;

import com.example.custom_queries2.entities.Flight;
import com.example.custom_queries2.entities.StatusEnum;
import com.example.custom_queries2.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/popolate")
    public ResponseEntity<Flight> popolateFlights(@RequestParam(value = "n", defaultValue = "100") Integer n){
        flightService.createRandomFlights(n);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public List<Flight> listOfFlights(){
        return flightService.flightsList();
    }

    @GetMapping("/retrive")
    public Page<Flight> allFlights(@RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(defaultValue = "10") Integer size) {
        return flightService.retriveFlights(page, size);
    }

    @GetMapping("/ontime")
    public List<Flight> ontimeFlights() {
        return flightService.flightOnTime();
    }

    @GetMapping("/status")
    public List<Flight> flightsByStatus(@RequestParam StatusEnum p1,
                                           @RequestParam StatusEnum p2) {
        return flightService.flightByStatus(p1, p2);
    }
}
