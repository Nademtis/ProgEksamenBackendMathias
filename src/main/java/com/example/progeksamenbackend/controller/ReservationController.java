package com.example.progeksamenbackend.controller;

import com.example.progeksamenbackend.dto.ReservationDTO;
import com.example.progeksamenbackend.model.Reservation;
import com.example.progeksamenbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;


    @PostMapping("addNewReservation/{username}/{date}/{roomID}")
    public ResponseEntity<ReservationDTO> addNewReservation(@PathVariable("username") String username,
                                                            @PathVariable("date") String stringDate,
                                                            @PathVariable("roomID") int roomID) {
        try {
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(stringDate, formatDate);
            return reservationService.addNewReservation(username, localDate, roomID);
        } catch (Exception e) {
            System.out.println("error in addNewReservation Controller: " + e);
            return ResponseEntity.badRequest().build();
        }

    }
}
