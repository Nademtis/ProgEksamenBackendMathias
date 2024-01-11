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
    private Hotel hotel;

    private LocalDateTime created;
    private LocalDateTime updated;

    @OneToMany(mappedBy="room")
    @Column(name = "reservation_id")
    private Set<Reservation> reservation;

}
