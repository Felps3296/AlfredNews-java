package com.felps.newssystem.controller;

import com.felps.newssystem.dto.PreferenceRequestDTO;
import com.felps.newssystem.dto.PreferenceResponseDTO;
import com.felps.newssystem.service.PreferenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/preference")
@RequiredArgsConstructor
public class PreferenceController {

    private final PreferenceService preferenceService;

    @PostMapping
    public ResponseEntity<PreferenceResponseDTO> addPreference(@RequestBody @Valid PreferenceRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(preferenceService.addPreference(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PreferenceResponseDTO>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(preferenceService.getPreferencesByUser(userId));
    }
}