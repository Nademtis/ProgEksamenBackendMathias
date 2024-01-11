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
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    private int guestID;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private LocalDateTime created;
    private LocalDateTime updated;

    @OneToMany(mappedBy="guest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "reservation_id")
    private Set<Reservation> reservation;
}
