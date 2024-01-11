package com.example.progeksamenbackend.service;

import com.example.progeksamenbackend.model.Guest;
import com.example.progeksamenbackend.repo.GuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GuestService {

    @Autowired
    GuestRepo guestRepo;

    public ResponseEntity<Guest> addNewGuest(Guest guest) {
        try {
            guest.setCreated(LocalDateTime.now());
            guestRepo.save(guest);
            return ResponseEntity.ok(guest);
        } catch (Error e) {
            System.out.println("Something went wrong in addNewGuest() :" + e);
            return ResponseEntity.noContent().build();
        }
    }
}
