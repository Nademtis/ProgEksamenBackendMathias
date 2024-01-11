package com.example.progeksamenbackend.repo;

import com.example.progeksamenbackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room, Integer> {
    int countByHotel_HotelID(int hotelID);
    List<Room> findByHotel_HotelID(int hotelID);
}
