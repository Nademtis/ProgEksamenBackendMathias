package com.example.progeksamenbackend.config;

import com.example.progeksamenbackend.model.Hotel;
import com.example.progeksamenbackend.model.Room;
import com.example.progeksamenbackend.repo.HotelRepo;
import com.example.progeksamenbackend.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class initData implements CommandLineRunner {

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    RoomRepo roomRepo;

    @Override
    public void run(String... args) throws Exception {
        initHotels();
    }

    public void initHotels() {


        for (int i = 1; i < 251; i++) {
            Hotel hotel = new Hotel();
            hotel.setName("Hotel " + i);
            hotel.setStreet("Street " + i);
            hotel.setCity("City " + i);
            hotel.setZip("Zip " + i);
            hotel.setCountry("Country " + i);
            hotel.setCreated(LocalDateTime.now());
            //hotel.setUpdated(LocalDateTime.now());

            hotelRepo.save(hotel);

            int roomAmount = new Random().nextInt(31) + 10;

            for (int j = 0; j < roomAmount; j++) {
                Room room = new Room();
                room.setRoomNumber(j + 1);
                room.setNumberOfBeds(new Random().nextInt(4) + 1);
                room.setRoomPrice(room.getNumberOfBeds() * 500);
                room.setHotel(hotel);
                room.setCreated(LocalDateTime.now());
//                room.setUpdated(LocalDateTime.now());

                roomRepo.save(room);
            }
        }
    }
}
