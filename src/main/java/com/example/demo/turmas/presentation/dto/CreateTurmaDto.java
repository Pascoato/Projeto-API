package com.example.demo.turmas.presentation.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTurmaDto(@NotBlank String nome, @NotBlank String curso, @NotBlank String periodo) {
}