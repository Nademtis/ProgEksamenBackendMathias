package com.example.progeksamenbackend.controller;

import com.example.progeksamenbackend.model.Guest;
import com.example.progeksamenbackend.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GuestController {

    @Autowired
    GuestService guestService;

    @PostMapping("addNewGuest")
    public ResponseEntity<Guest> addNewGuest(@RequestBody Guest guest){
        return guestService.addNewGuest(guest);
    }
}
