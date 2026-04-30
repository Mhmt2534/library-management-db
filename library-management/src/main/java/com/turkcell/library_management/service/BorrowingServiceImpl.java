package com.turkcell.library_management.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_management.dto.borrowing.request.CreateBorrowingRequestDto;
import com.turkcell.library_management.dto.borrowing.request.UpdateBorrowingRequestDto;
import com.turkcell.library_management.dto.borrowing.response.ListBorrowingResponse;
import com.turkcell.library_management.entity.BookCopy;
import com.turkcell.library_management.entity.Borrowing;
import com.turkcell.library_management.entity.Librarian;
import com.turkcell.library_management.entity.Student;
import com.turkcell.library_management.enums.BookStatus;
import com.turkcell.library_management.enums.BorrowStatus;
import com.turkcell.library_management.mapper.BorrowingMapper;
import com.turkcell.library_management.repository.BookCopyRepository;
import com.turkcell.library_management.repository.BorrowingRepository;
import com.turkcell.library_management.repository.LibrarianRepository;
import com.turkcell.library_management.repository.StudentRepository;

@Service
public class BorrowingServiceImpl {
    private final BorrowingRepository borrowingRepository;
    private final BookCopyRepository bookCopyRepository;
    private final StudentRepository studentRepository;
    private final LibrarianRepository librarianRepository;

    private final BookCopyServiceImpl bookCopyServiceImpl;

    public BorrowingServiceImpl(BorrowingRepository borrowingRepository,
            BookCopyRepository bookCopyRepository,
            StudentRepository studentRepository,
            LibrarianRepository librarianRepository,
        BookCopyServiceImpl bookCopyServiceImpl) {
        this.borrowingRepository = borrowingRepository;
        this.bookCopyRepository = bookCopyRepository;
        this.studentRepository = studentRepository;
        this.librarianRepository = librarianRepository;
        this.bookCopyServiceImpl = bookCopyServiceImpl;
    }

    public List<ListBorrowingResponse> getAll() {
        return borrowingRepository.findAll()
                .stream()
                .map(BorrowingMapper::toResponse)
                .toList();
    }

    public ListBorrowingResponse getById(UUID id) {
        Borrowing borrowing = borrowingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));

        return BorrowingMapper.toResponse(borrowing);
    }














    public void borrow(CreateBorrowingRequestDto request) {

        BookCopy bookCopy = bookCopyRepository.findById(request.getBookCopyId())
                .orElseThrow(() -> new RuntimeException("Book copy not found"));

        if (bookCopy.getStatus() != BookStatus.AVAILABLE) {
            throw new RuntimeException("Book copy is not available");
        }

        

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Librarian borrowedByLibrarian = librarianRepository.findById(request.getBorrowedByLibrarianId())
                .orElseThrow(() -> new RuntimeException("Librarian not found"));



        Instant now = Instant.now();

        Borrowing borrowing = new Borrowing();
        borrowing.setBookCopy(bookCopy);
        borrowing.setStudent(student);
        borrowing.setBorrowedByLibrarian(borrowedByLibrarian);
        borrowing.setBorrowedAt(now);
        borrowing.setDueAt(now.plus(15, ChronoUnit.DAYS));
        borrowing.setBorrowStatus(BorrowStatus.BORROWED);

        bookCopyServiceImpl.setBookStatus(bookCopy, BookStatus.BORROWED);
        

        borrowingRepository.save(borrowing);
    }



















    public void update(UUID id, UpdateBorrowingRequestDto request) {
        Borrowing borrowing = borrowingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));

        if (request.getReturnedToLibrarianId() != null) {
            Librarian returnedToLibrarian = librarianRepository.findById(request.getReturnedToLibrarianId())
                    .orElseThrow(() -> new RuntimeException("Librarian not found"));

            borrowing.setReturnedToLibrarian(returnedToLibrarian);
        }

        if (request.getReturnedAt() != null) {
            borrowing.setReturnedAt(request.getReturnedAt());
        }

        if (request.getBorrowStatus() != null) {
            borrowing.setBorrowStatus(request.getBorrowStatus());

            if (request.getBorrowStatus() == BorrowStatus.RETURNED) {
                borrowing.getBookCopy().setStatus(BookStatus.AVAILABLE);

                if (borrowing.getReturnedAt() == null) {
                    borrowing.setReturnedAt(Instant.now());
                }
            }
        }

        borrowingRepository.save(borrowing);
        bookCopyRepository.save(borrowing.getBookCopy());
    }

    public void delete(UUID id) {
        Borrowing borrowing = borrowingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));

        borrowingRepository.delete(borrowing);
    }
}
