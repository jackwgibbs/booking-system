package com.example.booking.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="APPOINTMENT")
public class Appointment {

    @Id
    @GeneratedValue
    @Column(name="appointmentId")
    private String appointmentId;

    @Column(name="title")
    private String title;

    @Column(name="type")
    private String type;

    @Column(name="startDate")
    private LocalDateTime startDate;

    @Column(name="endDate")
    private LocalDateTime endDate;

    @Column(name="notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "staffId", referencedColumnName = "staffId")
    private Staff staff;
}