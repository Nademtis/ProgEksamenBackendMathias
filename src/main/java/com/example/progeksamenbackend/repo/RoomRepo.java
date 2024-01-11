package com.example.progeksamenbackend.repo;

import com.example.progeksamenbackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, Integer> {
}
