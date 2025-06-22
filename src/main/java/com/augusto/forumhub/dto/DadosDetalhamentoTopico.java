package com.augusto.forumhub.dto;

import com.augusto.forumhub.model.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, Long autorId, Long cursoId){
    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutor().getId(), topico.getCurso().getId());
    }
}
