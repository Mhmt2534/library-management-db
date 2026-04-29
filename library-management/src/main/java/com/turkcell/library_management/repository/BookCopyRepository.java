package com.turkcell.library_management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.library_management.entity.BookCopy;

public interface BookCopyRepository extends JpaRepository<BookCopy,UUID>{

}
