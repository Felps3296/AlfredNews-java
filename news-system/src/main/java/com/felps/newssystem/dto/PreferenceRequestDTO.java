package com.felps.newssystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class PreferenceRequestDTO {

    @NotNull(message = "user ID é obrigatório")
    private Long userId;

    @NotBlank(message = "Categoria é obrigatória")
    private String category;
}
