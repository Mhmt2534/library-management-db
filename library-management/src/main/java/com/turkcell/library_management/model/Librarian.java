package com.turkcell.library_management.model;

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
@Table(name = "books")
public class Librarian {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "librarian_name")
    private String librarianName;

    @Column(name = "librarian_surname")
    private String librarianSurname;

    @Column(name = "phone_number")
    private String phoneNumber ;

    @Enumerated(EnumType.STRING)
    @Column(name = "shift")
    private Shift shift;

    @OneToMany(mappedBy = "borrowedByLibrarian")
    private Set<Borrowing> borrowingsGiven;

    @OneToMany(mappedBy = "returnedToLibrarian")
    private Set<Borrowing> borrowingsReceived;


}
