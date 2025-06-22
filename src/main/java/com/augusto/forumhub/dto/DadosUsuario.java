package com.augusto.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosUsuario(@NotNull Long id, @NotBlank String email, @NotBlank String senha) {
}
