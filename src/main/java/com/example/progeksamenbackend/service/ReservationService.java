package com.example.progeksamenbackend.service;

import com.example.progeksamenbackend.dto.ReservationConverter;
import com.example.progeksamenbackend.dto.ReservationDTO;
import com.example.progeksamenbackend.model.Guest;
import com.example.progeksamenbackend.model.Reservation;
import com.example.progeksamenbackend.model.Room;
import com.example.progeksamenbackend.repo.GuestRepo;
import com.example.progeksamenbackend.repo.ReservationRepo;
import com.example.progeksamenbackend.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepo reservationRepo;

    @Autowired
    GuestRepo guestRepo;

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    ReservationConverter reservationConverter;

    public ResponseEntity<ReservationDTO> addNewReservation(String username, LocalDate date, int roomID) {
        Reservation reservation = new Reservation();
        Optional<Room> room = roomRepo.findById(roomID);

        if (room.isPresent()) {
            reservation.setRoom(room.get());
            reservation.setReservationDate(date);
            //TODO CHECK FOR ALLREADY BOOKED TIME
            Guest guest = guestRepo.findByUsername(username);
            reservation.setGuest(guest);
            reservation.setCreated(LocalDateTime.now());
            System.out.println(reservation);

            reservationRepo.save(reservation);
            ReservationDTO reservationDTO = reservationConverter.toDTO(reservation);
            return ResponseEntity.ok(reservationDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    public ResponseEntity<List<ReservationDTO>> getReservations(String username) {
        Optional<Guest> optGuest = Optional.ofNullable(guestRepo.findByUsername(username));

        if (optGuest.isPresent()) {
            Guest guest = optGuest.get();
            List<Reservation> reservationList = reservationRepo.findByGuest_GuestID(guest.getGuestID());
            List<ReservationDTO> reservationDTOList = new ArrayList<>();

            for (Reservation reservation : reservationList) {
                reservationDTOList.add(reservationConverter.toDTO(reservation));
            }
            return ResponseEntity.ok(reservationDTOList);
        } else {
            System.out.println("Error in getReservations");
            return ResponseEntity.badRequest().build();
        }
    }


    public ResponseEntity<Void> deleteReservation(int reservationID) {
        Optional<Reservation> optReservation = reservationRepo.findById(reservationID);

        if (optReservation.isPresent()) {
            Reservation reservation = optReservation.get();
            reservationRepo.delete(reservation);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
