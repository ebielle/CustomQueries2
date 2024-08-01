package com.example.custom_queries2.services;

import com.example.custom_queries2.entities.Flight;
import com.example.custom_queries2.entities.StatusEnum;
import com.example.custom_queries2.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public void createRandomFlights(Integer n){
        Random random = new Random();

        for(int i = 0; i <= n; i++){
            Flight flight = new Flight(i, random.toString(), random.toString(), random.toString(), StatusEnum.randomStatusEnum());
            flightRepository.save(flight);
        }
    }

    public List<Flight> flightsList(){
        return flightRepository.findAll();
    }

    public Page<Flight> retriveFlights(Integer page, Integer size){
        return flightRepository.findAll(PageRequest.of(page, size, Sort.by("fromAirport").ascending()));
    }

    public List<Flight> flightOnTime(){
        return flightRepository.findByStatus(StatusEnum.ONTIME);
    }

    public List<Flight> flightByStatus(StatusEnum p1, StatusEnum p2){
        return flightRepository.findByStatus(p1, p2);
    }
}
