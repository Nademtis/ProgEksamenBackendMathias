package com.example.progeksamenbackend.repo;

import com.example.progeksamenbackend.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,Integer> {
}
