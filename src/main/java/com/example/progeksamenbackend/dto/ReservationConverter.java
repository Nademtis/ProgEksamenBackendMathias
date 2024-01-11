package com.example.progeksamenbackend.dto;

import com.example.progeksamenbackend.model.Reservation;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReservationConverter {
    public ReservationDTO toDTO(Reservation reservation) {
        return new ReservationDTO(reservation.getRevervationID(), reservation.getReservationDate(),
                reservation.getRoom().getRoomID(), reservation.getGuest().getGuestID());
    }
}
