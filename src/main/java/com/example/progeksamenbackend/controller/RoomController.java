package com.example.progeksamenbackend.controller;

import com.example.progeksamenbackend.model.Room;
import com.example.progeksamenbackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("addNewRoom")
    public ResponseEntity<Room> addNewRoom(@RequestBody Room room){
        return roomService.addNewRoom(room);
    }

}
