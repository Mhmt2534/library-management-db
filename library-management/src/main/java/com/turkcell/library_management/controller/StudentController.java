package com.turkcell.library_management.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_management.dto.student.request.CreateStudentRequestDto;
import com.turkcell.library_management.dto.student.request.UpdateStudentRequestDto;
import com.turkcell.library_management.dto.student.response.ListStudentResponse;
import com.turkcell.library_management.service.StudentServiceImpl;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public List<ListStudentResponse> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/get/{id}")
    public ListStudentResponse getById(@PathVariable UUID id) {
        return studentService.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody CreateStudentRequestDto requestDto) {
        studentService.create(requestDto);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable UUID id,
                        @RequestBody UpdateStudentRequestDto request) {
        studentService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        studentService.delete(id);
    }
}