package com.example.progeksamenbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int roomID;

    @Column(name = "room_number")
    private int roomNumber;

    @Column(name = "room_price")
    private double roomPrice;

    @Column(name = "number_of_beds")
    private int numberOfBeds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
//    @JsonBackReference
//    @JsonIgnoreProperties("room")
    private Hotel hotel;

    private LocalDateTime created;
    private LocalDateTime updated;

    @OneToMany(mappedBy="room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "reservation_id")
//    @JsonManagedReference
//    @JsonIgnoreProperties("room")
    private Set<Reservation> reservation;

}
