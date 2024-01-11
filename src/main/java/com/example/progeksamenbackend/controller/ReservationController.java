package com.example.progeksamenbackend.controller;

import com.example.progeksamenbackend.dto.ReservationDTO;
import com.example.progeksamenbackend.model.Reservation;
import com.example.progeksamenbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("getReservations/{username}")
    public ResponseEntity<List<ReservationDTO>> getReservations(@PathVariable("username") String username){
        return reservationService.getReservations(username);
    }

    @DeleteMapping("deleteReservation/{reservationID}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("reservationID") int reservationID){
        return reservationService.deleteReservation(reservationID);
    }
}
