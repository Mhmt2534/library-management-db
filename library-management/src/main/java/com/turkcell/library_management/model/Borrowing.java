package com.turkcell.library_management.model;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "borrowings")
public class Borrowing {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "book_copy_id")
    private BookCopy bookCopy;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "borrowed_by_librarian_id")
    private Librarian borrowedByLibrarian;

    @ManyToOne
    @JoinColumn(name = "returned_to_librarian_id", nullable = true)
    private Librarian returnedToLibrarian;

    @Column(name = "borrowed_at")
    private Instant borrowedAt;

    @Column(name = "due_at", nullable = true)
    private Instant dueAt;

    @Column(name = "returned_at", nullable = true)
    private Instant returnedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BorrowStatus borrowStatus;


    @OneToOne(mappedBy = "borrowing")
    private Penalty penalty;
}
