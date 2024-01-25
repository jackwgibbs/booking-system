package com.example.booking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="STAFF")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="staffId")
    private Long staffId;

    @Column(name="forename")
    private String forename;

    @Column(name="surname")
    private String surname;

    @OneToMany(mappedBy = "staff")
    private List<Appointment> appointments;
}