package com.augusto.forumhub.dto;

import com.augusto.forumhub.model.Topico;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosRetornoTopico(String titulo, String mensagem, @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dataCriacao, Boolean estadoTopico, Long autor_id, Long curso_id) {

    public DadosRetornoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getEstadoTopico(), topico.getAutor().getId(), topico.getCurso().getId());
    }
}
