package com.example.progeksamenbackend.dto;

public record HotelDTO(int hotelID, String name, String street, String city, String zip, String country,
                       int amountOfRooms) {

}
