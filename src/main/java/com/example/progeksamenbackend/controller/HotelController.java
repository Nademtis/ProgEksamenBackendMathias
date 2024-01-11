package com.example.progeksamenbackend.controller;

import com.example.progeksamenbackend.dto.HotelDTO;
import com.example.progeksamenbackend.model.Hotel;
import com.example.progeksamenbackend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("addNewHotel")
    public ResponseEntity<Hotel> addNewHotel(@RequestBody Hotel hotel){
        return hotelService.addNewHotel(hotel);
    }
    @GetMapping("getAllHotels")
    public ResponseEntity<List<HotelDTO>> getAllHotels(){
        return hotelService.getAllHotels();
    }

    @PutMapping("updateHotel")
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody Hotel hotel){
        return hotelService.updateHotel(hotel);
    }

}
