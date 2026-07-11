package com.felps.newssystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "preferences")
public class Preference {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
