package com.turkcell.library_management.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_management.dto.penalty.request.CreatePenaltyRequestDto;
import com.turkcell.library_management.dto.penalty.request.UpdatePenaltyRequestDto;
import com.turkcell.library_management.dto.penalty.response.ListPenaltyResponse;
import com.turkcell.library_management.entity.Borrowing;
import com.turkcell.library_management.entity.Penalty;
import com.turkcell.library_management.mapper.PenaltyMapper;
import com.turkcell.library_management.repository.BorrowingRepository;
import com.turkcell.library_management.repository.PenaltyRepository;

@Service
public class PenaltyServiceImpl {
    private final PenaltyRepository penaltyRepository;
    private final BorrowingRepository borrowingRepository;

    public PenaltyServiceImpl(PenaltyRepository penaltyRepository, BorrowingRepository borrowingRepository) {
        this.penaltyRepository = penaltyRepository;
        this.borrowingRepository = borrowingRepository;
    }

    public List<ListPenaltyResponse> getAll() {
        return penaltyRepository.findAll()
                .stream()
                .map(PenaltyMapper::toResponse)
                .toList();
    }

    public ListPenaltyResponse getById(UUID id) {
        Penalty penalty = penaltyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Penalty not found"));

        return PenaltyMapper.toResponse(penalty);
    }

    public void create(CreatePenaltyRequestDto request) {
        Borrowing borrowing = borrowingRepository.findById(request.getBorrowingId())
                .orElseThrow(() -> new RuntimeException("Borrowing not found"));

        // Check if penalty already exists for this borrowing
        if (borrowing.getPenalty() != null) {
            throw new RuntimeException("Penalty already exists for this borrowing");
        }

        Penalty penalty = PenaltyMapper.toEntity(request);
        penalty.setBorrowing(borrowing);

        penaltyRepository.save(penalty);
    }

    public void update(UUID id, UpdatePenaltyRequestDto request) {
        Penalty penalty = penaltyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Penalty not found"));

        PenaltyMapper.updateEntity(penalty, request);
        penaltyRepository.save(penalty);
    }

    public void delete(UUID id) {
        Penalty penalty = penaltyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Penalty not found"));

        penaltyRepository.delete(penalty);
    }
}
