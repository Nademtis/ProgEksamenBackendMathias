package com.example.progeksamenbackend.dto;

import com.example.progeksamenbackend.model.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelConverter {
    public HotelDTO toDTO(Hotel hotel) {
        return new HotelDTO(hotel.getHotelID(), hotel.getName(), hotel.getStreet(),
                hotel.getCity(), hotel.getZip(), hotel.getCountry());
    }
}
