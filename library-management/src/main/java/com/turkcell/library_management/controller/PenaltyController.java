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

import com.turkcell.library_management.dto.penalty.request.CreatePenaltyRequestDto;
import com.turkcell.library_management.dto.penalty.request.UpdatePenaltyRequestDto;
import com.turkcell.library_management.dto.penalty.response.ListPenaltyResponse;
import com.turkcell.library_management.service.PenaltyServiceImpl;

@RestController
@RequestMapping("/api/penalties")
public class PenaltyController {
    private final PenaltyServiceImpl penaltyService;

    public PenaltyController(PenaltyServiceImpl penaltyService) {
        this.penaltyService = penaltyService;
    }

    @GetMapping("/getAll")
    public List<ListPenaltyResponse> getAll() {
        return penaltyService.getAll();
    }

    @GetMapping("/get/{id}")
    public ListPenaltyResponse getById(@PathVariable UUID id) {
        return penaltyService.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody CreatePenaltyRequestDto requestDto) {
        penaltyService.create(requestDto);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable UUID id,
                       @RequestBody UpdatePenaltyRequestDto request) {
        penaltyService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        penaltyService.delete(id);
    }
}
