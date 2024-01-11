package com.example.progeksamenbackend.service;

import com.example.progeksamenbackend.model.Hotel;
import com.example.progeksamenbackend.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HotelService {

    @Autowired
    HotelRepo hotelRepo;

    public ResponseEntity<Hotel> addNewHotel(Hotel hotel) {
        try {
            LocalDateTime timeNow = LocalDateTime.now();
            hotel.setCreated(timeNow);
            hotelRepo.save(hotel);
            return ResponseEntity.ok(hotel);
        } catch (Error e) {
            System.out.println("error in addNewHotel: " + e);
            return ResponseEntity.noContent().build();
        }

    }
}
