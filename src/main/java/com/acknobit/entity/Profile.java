package com.acknobit.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "files")
@Getter
@Service
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProfileService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String preferredComm;
    private String avatarUrl;
}
