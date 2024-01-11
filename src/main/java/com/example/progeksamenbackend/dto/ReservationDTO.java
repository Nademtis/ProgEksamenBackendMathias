package com.example.progeksamenbackend.dto;

import java.time.LocalDate;

public record ReservationDTO(int reservationID,
                             LocalDate reservationDate,
                             int room_id,
                             int guest_id) {
}
