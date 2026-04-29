package com.turkcell.library_management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.library_management.entity.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian,UUID>{

}
