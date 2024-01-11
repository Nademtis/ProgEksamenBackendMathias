package com.example.progeksamenbackend.repo;

import com.example.progeksamenbackend.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepo extends JpaRepository<Guest,Integer> {
}
