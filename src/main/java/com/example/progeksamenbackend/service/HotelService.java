package com.example.progeksamenbackend.service;

import com.example.progeksamenbackend.dto.HotelConverter;
import com.example.progeksamenbackend.dto.HotelDTO;
import com.example.progeksamenbackend.model.Hotel;
import com.example.progeksamenbackend.repo.HotelRepo;
import com.example.progeksamenbackend.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    HotelConverter hotelConverter;

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

    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        try {
            List<Hotel> hotelList = hotelRepo.findAll();
            List<HotelDTO> hotelDTOList = new ArrayList<>();
            for (int i = 0; i < hotelList.size(); i++) {
//                int amountOfRoomsInHotel = roomRepo.countByHotel_HotelID(hotelList.get(i).getHotelID());
                int amountOfRoomsInHotel = getRoomAmount(hotelList.get(i).getHotelID());
                hotelDTOList.add(hotelConverter.toDTO(hotelList.get(i), amountOfRoomsInHotel));
            }
            return ResponseEntity.ok(hotelDTOList);
        } catch (Error e) {
            System.out.println("error in getAllHotels: " + e);
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<HotelDTO> updateHotel(Hotel hotel) {
        Optional<Hotel> optHotel = hotelRepo.findById(hotel.getHotelID());

        if (optHotel.isPresent()){
            Hotel updatedHotel = optHotel.get();

            updatedHotel.setName(hotel.getName());
            updatedHotel.setStreet(hotel.getStreet());
            updatedHotel.setCity(hotel.getCity());
            updatedHotel.setZip(hotel.getZip());
            updatedHotel.setCountry(hotel.getCountry());

            updatedHotel.setUpdated(LocalDateTime.now());

            hotelRepo.save(updatedHotel);
            return ResponseEntity.ok(hotelConverter.toDTO(updatedHotel, getRoomAmount(updatedHotel.getHotelID())));
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    private int getRoomAmount(int hotelID){
        return roomRepo.countByHotel_HotelID(hotelID);
    }
}
