package com.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_otp")
    private int userOtp;

    @Column(name = "user_email")
    private String email;

    private LocalDateTime createdAt;

    @Column(name = "otp_validity")
    private LocalDateTime validTill;
}
