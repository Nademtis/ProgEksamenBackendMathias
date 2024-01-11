package com.example.progeksamenbackend.controller;

import com.example.progeksamenbackend.dto.RoomDTO;
import com.example.progeksamenbackend.model.Room;
import com.example.progeksamenbackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("addNewRoom/{roomPrice}/{numberOfBeds}/{hotelID}")
    public ResponseEntity<RoomDTO> addNewRoom(@PathVariable("roomPrice") double roomPrice,
                                              @PathVariable("numberOfBeds")int numberOfBeds,
                                              @PathVariable("hotelID")int hotelID){
        return roomService.addNewRoom(roomPrice, numberOfBeds, hotelID);
    }

    @GetMapping("getRooms/{hotelID}")
    public ResponseEntity<List<RoomDTO>> getRoomsInHotel(@PathVariable("hotelID") int hotelID){
        return roomService.getRoomsInHotel(hotelID);
    }

}
