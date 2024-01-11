package com.example.progeksamenbackend.controller;

import com.example.progeksamenbackend.model.Hotel;
import com.example.progeksamenbackend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("addNewHotel")
    public ResponseEntity<Hotel> addNewHotel(@RequestBody Hotel hotel){
        return hotelService.addNewHotel(hotel);
    }

}
