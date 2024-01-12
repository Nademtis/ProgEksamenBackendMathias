package com.example.progeksamenbackend.repo;

import com.example.progeksamenbackend.model.Guest;
import com.example.progeksamenbackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByGuest_GuestID(int guestID);
    Reservation findByReservationDateAndRoom_RoomID(LocalDate date, int roomID);
}
