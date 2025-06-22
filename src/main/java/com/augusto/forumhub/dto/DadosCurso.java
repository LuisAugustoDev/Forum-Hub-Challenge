package com.augusto.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCurso(@NotNull Long id, @NotBlank String nome){
}
