package com.example.progeksamenbackend.dto;

import com.example.progeksamenbackend.model.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomConverter {
    public RoomDTO toDTO(Room room) {
        return new RoomDTO(room.getHotel().getHotelID(), room.getNumberOfBeds(), room.getRoomID(),
                room.getRoomNumber(), room.getRoomPrice());
    }
}
