package com.example.progeksamenbackend.controller;

import com.example.progeksamenbackend.model.Room;
import com.example.progeksamenbackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("addNewRoom/{roomPrice}/{numberOfBeds}/{hotelID}")
    public ResponseEntity<Room> addNewRoom(@PathVariable("roomPrice") double roomPrice,
                                           @PathVariable("numberOfBeds")int numberOfBeds,
                                           @PathVariable("hotelID")int hotelID){
        return roomService.addNewRoom(roomPrice, numberOfBeds, hotelID);
    }

}
