package com.turkcell.library_management.model;

import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private UUID id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "shelf_number")
    private String shelfNumber;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;


    //Bir kitabın birden fazla kategorisi olabilir, bir kategorinin birden 
    // fazla kitabı olabilir. ManyToMany
    //Owner -> Join table
    //Digeri -> mappedBy
    @ManyToMany
    @JoinTable(
        name = "book_categories",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    @OneToMany(mappedBy = "book")
    private Set<BookCopy> bookCopies;


}
