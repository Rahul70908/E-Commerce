package com.user.entity;

import com.user.util.UserSequenceGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user_detail", schema = "public")
public class User {

    @Id
    @Column(name = "user_id", columnDefinition = "bigint")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom")
    @GenericGenerator(name = "custom", type = UserSequenceGenerator.class)
    private Long id;

    @Column(name = "user_email", nullable = false)
    private String email;

    @CreationTimestamp
    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @UpdateTimestamp
    @Column(name = "modified_on")
    private Timestamp modifiedOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    private String activeStatus;
}
