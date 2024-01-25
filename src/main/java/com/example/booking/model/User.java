package com.example.booking.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name="userId")
    private String userId;

    @Column(name="forename")
    private String forename;

    @Column(name="surname")
    private String surname;

    @OneToMany(mappedBy = "user")
    private List<Appointment> appointments;
}
