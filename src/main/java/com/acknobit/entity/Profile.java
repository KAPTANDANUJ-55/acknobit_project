package com.acknobit.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "files")
@Getter
@Setter
@Service
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String preferredComm;
    private String avatarUrl;
}
