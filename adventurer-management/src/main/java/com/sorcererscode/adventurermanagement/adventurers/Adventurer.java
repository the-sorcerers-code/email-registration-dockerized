package com.sorcererscode.adventurermanagement.adventurers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "p_adventurers")
public class Adventurer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "p_adventurers_seq")
    @SequenceGenerator(name = "p_adventurers_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firstName;
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String homeAddress;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;
}
