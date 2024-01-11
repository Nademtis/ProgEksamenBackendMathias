package com.example.progeksamenbackend.service;
import com.example.progeksamenbackend.dto.HotelDTO;
import com.example.progeksamenbackend.model.Hotel;
import com.example.progeksamenbackend.repo.HotelRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HotelServiceTest {

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    HotelService hotelService;

    @Test
    void addNewHotelTest() {
        Hotel hotelToAdd = new Hotel();
        hotelToAdd.setName("Test Hotel");
        hotelToAdd.setStreet("Test Street");
        hotelToAdd.setCity("Test City");
        hotelToAdd.setZip("12345");
        hotelToAdd.setCountry("Test Country");

        hotelToAdd.setCreated(LocalDateTime.now());
        hotelService.addNewHotel(hotelToAdd);

        Optional<Hotel> optHotel = hotelRepo.findById(hotelToAdd.getHotelID());
        Hotel actualHotel = optHotel.get();

        assertEquals("Test Hotel", actualHotel.getName());
        assertEquals("Test Street", actualHotel.getStreet());
        assertEquals("Test City", actualHotel.getCity());
        assertEquals("12345", actualHotel.getZip());
        assertEquals("Test Country", actualHotel.getCountry());
    }


    @Test
    void updateHotelTest() {
        Hotel hotelToUpdate = new Hotel();
        hotelToUpdate.setName("Test Hotel");
        hotelToUpdate.setStreet("Test Street");
        hotelToUpdate.setCity("Test City");
        hotelToUpdate.setZip("12345");
        hotelToUpdate.setCountry("TestCountry");
        hotelToUpdate.setCreated(LocalDateTime.now());

        hotelService.addNewHotel(hotelToUpdate);

        hotelToUpdate.setName("Updated Hotel Name");
        ResponseEntity<HotelDTO> httpStatusToCheck = hotelService.updateHotel(hotelToUpdate);

        assertEquals(HttpStatus.OK, httpStatusToCheck.getStatusCode());

        // Fetch the updated hotel and assert the changes
        Optional<Hotel> updatedOptHotel = hotelRepo.findById(hotelToUpdate.getHotelID());
        Hotel updatedHotel = updatedOptHotel.get();

        assertEquals("Updated Hotel Name", updatedHotel.getName());
    }
}