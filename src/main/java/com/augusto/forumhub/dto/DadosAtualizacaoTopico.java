package com.augusto.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        Boolean estadoTopico,
        @NotNull
        Long autorId,
        @NotNull
        Long cursoId) {
}
