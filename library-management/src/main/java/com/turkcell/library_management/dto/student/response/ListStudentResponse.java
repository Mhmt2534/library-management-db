package com.turkcell.library_management.dto.student.response;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.turkcell.library_management.dto.borrowing.response.BorrowingSimpleDto;
import com.turkcell.library_management.enums.StudentStatus;

public class ListStudentResponse {
    private UUID id;
    private String studentName;
    private String studentSurname;
    private String phoneNumber;
    private String identityNumber;
    private Instant createdAt;
    private StudentStatus status;
    private List<BorrowingSimpleDto> borrowings;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public List<BorrowingSimpleDto> getBorrowings() {
        return borrowings;
    }

    public void setBorrowings(List<BorrowingSimpleDto> borrowings) {
        this.borrowings = borrowings;
    }
}