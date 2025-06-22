package com.augusto.forumhub.dto;

import com.augusto.forumhub.model.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, Long autor_id, Long curso_id){
    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutorId(), topico.getCursoId());
    }
}
