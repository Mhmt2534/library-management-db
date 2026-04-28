package com.turkcell.library_management.entity;

import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.turkcell.library_management.enums.BookStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_copies")
public class BookCopy {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToMany(mappedBy = "bookCopy")
    private Set<Borrowing> borrowings;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<Borrowing> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(Set<Borrowing> borrowings) {
        this.borrowings = borrowings;
    }


    
    
}
