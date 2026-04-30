package com.turkcell.library_management.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_management.dto.student.request.CreateStudentRequestDto;
import com.turkcell.library_management.dto.student.request.UpdateStudentRequestDto;
import com.turkcell.library_management.dto.student.response.ListStudentResponse;
import com.turkcell.library_management.entity.Student;
import com.turkcell.library_management.mapper.StudentMapper;
import com.turkcell.library_management.repository.StudentRepository;

@Service
public class StudentServiceImpl {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<ListStudentResponse> getAll() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::toResponse)
                .toList();
    }

    public ListStudentResponse getById(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return StudentMapper.toResponse(student);
    }

    public void create(CreateStudentRequestDto request) {
        Student student = StudentMapper.toEntity(request);
        student.setCreatedAt(Instant.now());
        studentRepository.save(student);
    }

    public void update(UUID id, UpdateStudentRequestDto requestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        StudentMapper.updateEntity(student, requestDto);
        studentRepository.save(student);
    }

    public void delete(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentRepository.delete(student);
    }
}