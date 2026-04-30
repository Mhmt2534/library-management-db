package com.turkcell.library_management.mapper;

import com.turkcell.library_management.dto.borrowing.response.BorrowingSimpleDto;
import com.turkcell.library_management.dto.student.request.CreateStudentRequestDto;
import com.turkcell.library_management.dto.student.request.UpdateStudentRequestDto;
import com.turkcell.library_management.dto.student.response.ListStudentResponse;
import com.turkcell.library_management.entity.Student;

public class StudentMapper {

    public static ListStudentResponse toResponse(Student student) {
        ListStudentResponse response = new ListStudentResponse();

        response.setId(student.getId());
        response.setStudentName(student.getStudentName());
        response.setStudentSurname(student.getStudentSurname());
        response.setPhoneNumber(student.getPhoneNumber());
        response.setIdentityNumber(student.getIdentityNumber());
        response.setCreatedAt(student.getCreatedAt());
        response.setStatus(student.getStatus());

        response.setBorrowings(
            student.getBorrowings()
                .stream()
                .map(borrowing -> new BorrowingSimpleDto(
                    borrowing.getId(),
                    borrowing.getBorrowedAt(),
                    borrowing.getDueAt(),
                    borrowing.getReturnedAt(),
                    borrowing.getBorrowStatus()
                ))
                .toList()
        );

        return response;
    }

    public static Student toEntity(CreateStudentRequestDto request) {
        Student student = new Student();
        student.setStudentName(request.getStudentName());
        student.setStudentSurname(request.getStudentSurname());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setIdentityNumber(request.getIdentityNumber());
        student.setStatus(request.getStatus());
        return student;
    }

    public static void updateEntity(Student student, UpdateStudentRequestDto request) {
        student.setStudentName(request.getStudentName());
        student.setStudentSurname(request.getStudentSurname());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setIdentityNumber(request.getIdentityNumber());
        student.setStatus(request.getStatus());
    }
}