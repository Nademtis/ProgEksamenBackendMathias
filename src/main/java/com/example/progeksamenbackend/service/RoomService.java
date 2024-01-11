package com.example.progeksamenbackend.service;

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

    public ResponseEntity<Room> addNewRoom(Room room) {
        System.out.println("room look like: " + room);
        Optional<Hotel> optHotel = hotelRepo.findById(room.getHotel().getHotelID());


        if (optHotel.isPresent()) {
            room.setCreated(LocalDateTime.now());
            //room.setRoomNumber(roomRepo.countByHotel_HotelID(optHotel.get().getHotelID()) + 1);
            roomRepo.save(room);
            return ResponseEntity.ok(room);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
