package com.acknobit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "leads")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    private String service;

    private String budget;

    @Column(length = 2000)
    private String projectDescription;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Lead(String fullName, String phoneNumber, String email, String service, String budget, String projectDescription) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.service = service;
        this.budget = budget;
        this.projectDescription = projectDescription;
    }
}
