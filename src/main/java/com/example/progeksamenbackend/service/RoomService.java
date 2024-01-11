package com.example.progeksamenbackend.service;

import com.example.progeksamenbackend.dto.RoomConverter;
import com.example.progeksamenbackend.dto.RoomDTO;
import com.example.progeksamenbackend.model.Hotel;
import com.example.progeksamenbackend.model.Room;
import com.example.progeksamenbackend.repo.HotelRepo;
import com.example.progeksamenbackend.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    RoomConverter roomConverter;

    public ResponseEntity<RoomDTO> addNewRoom(double roomPrice, int numberOfBeds, int hotelID) {
        Optional<Hotel> optHotel = hotelRepo.findById(hotelID);

        if (optHotel.isPresent()) {
            Hotel hotel = optHotel.get();
            Room newRoom = new Room();
            newRoom.setRoomNumber(roomRepo.countByHotel_HotelID(hotelID) + 1);
            newRoom.setRoomPrice(roomPrice);
            newRoom.setNumberOfBeds(numberOfBeds);
            newRoom.setHotel(hotel);

            newRoom.setCreated(LocalDateTime.now());
            System.out.println(newRoom);
            roomRepo.save(newRoom);

            RoomDTO roomDTO = roomConverter.toDTO(newRoom);
            return ResponseEntity.ok(roomDTO);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
