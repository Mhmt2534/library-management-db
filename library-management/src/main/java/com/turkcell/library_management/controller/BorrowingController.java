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

import com.turkcell.library_management.dto.borrowing.request.CreateBorrowingRequestDto;
import com.turkcell.library_management.dto.borrowing.request.UpdateBorrowingRequestDto;
import com.turkcell.library_management.dto.borrowing.response.ListBorrowingResponse;
import com.turkcell.library_management.service.BorrowingServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {
    private final BorrowingServiceImpl borrowingService;

    public BorrowingController(BorrowingServiceImpl borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping("/getAll")
    public List<ListBorrowingResponse> getAll() {
        return borrowingService.getAll();
    }

    @GetMapping("/get/{id}")
    public ListBorrowingResponse getById(@PathVariable UUID id) {
        return borrowingService.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody CreateBorrowingRequestDto requestDto) {
        borrowingService.borrow(requestDto);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable UUID id,
                       @RequestBody UpdateBorrowingRequestDto request) {
        borrowingService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        borrowingService.delete(id);
    }





}
