package com.example.progeksamenbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private int hotelID;

    private String name;

    private String street;
    private String city;
    private String zip;
    private String country;

    private LocalDateTime created;
    private LocalDateTime updated;

    @OneToMany(mappedBy="hotel")
    @Column(name = "room_id")
    private Set<Room> room;

    public Hotel(String name, String street, String city, String zip, String country, LocalDateTime created) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.created = created;
    }
}
