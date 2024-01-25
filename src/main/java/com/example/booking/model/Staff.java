package com.example.booking.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="STAFF")
public class Staff {

    @Id
    @GeneratedValue
    @Column(name="staffId")
    private String staffId;

    @Column(name="forename")
    private String forename;

    @Column(name="surname")
    private String surname;

    @OneToMany(mappedBy = "staff")
    private List<Appointment> appointments;
}