package com.example.progeksamenbackend.config;

import com.example.progeksamenbackend.model.Hotel;
import com.example.progeksamenbackend.model.Room;
import com.example.progeksamenbackend.repo.HotelRepo;
import com.example.progeksamenbackend.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class initData implements CommandLineRunner {

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    RoomRepo roomRepo;

    @Override
    public void run(String... args) throws Exception {
//        initHotels();
    }

    public void initHotels() {


        for (int i = 0; i < 250; i++) {
            Hotel hotel = new Hotel();
            int roomAmount = new Random().nextInt(10,40);

            for (int j = 0; j < roomAmount; j++) {
                Room room = new Room();
                int bedAmount = new Random().nextInt(1,4);

                for (int k = 0; k < bedAmount; k++) {

                }

                roomRepo.save(room);
            }
            hotelRepo.save(hotel);
        }
    }
}
