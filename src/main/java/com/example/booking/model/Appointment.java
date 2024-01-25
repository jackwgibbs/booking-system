package com.example.booking.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="APPOINTMENT")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="appointmentId")
    private Long appointmentId;

    @Column(name="title")
    private String title;

    @Column(name="type")
    private String type;

    @Column(name="location")
    private String location;

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