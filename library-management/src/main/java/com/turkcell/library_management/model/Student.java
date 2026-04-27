package com.turkcell.library_management.model;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String studentName;

    @Column(name = "surname")
    private String studentSurname;

    @Column(name = "phone_number")
    private String phoneNumber ;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @OneToMany(mappedBy = "student")
    private Set<Borrowing> borrowings;

}
