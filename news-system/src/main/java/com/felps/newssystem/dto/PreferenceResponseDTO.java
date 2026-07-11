package com.felps.newssystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PreferenceResponseDTO {
    private Long id;
    private String category;
    private Long userID;
}
