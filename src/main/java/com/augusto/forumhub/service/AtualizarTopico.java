package com.augusto.forumhub.service;

import com.augusto.forumhub.dto.DadosAtualizacaoTopico;
import com.augusto.forumhub.infra.exception.ValidacaoException;
import com.augusto.forumhub.model.Topico;
import com.augusto.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarTopico {

    @Autowired
    TopicoRepository repository;

    public Topico atualizar(DadosAtualizacaoTopico dados){
        var topico = repository.findById(dados.id());
        if(topico.isEmpty()){
            throw new ValidacaoException("Nenhum tópico encontrado com esse ID para atualização!");
        }
        topico.get().atualizarInformacoes(dados);
        return topico.get();
    }
}
