package com.augusto.forumhub.service;

import com.augusto.forumhub.infra.exception.ValidacaoException;
import com.augusto.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarTopico {

    @Autowired
    TopicoRepository repository;

    public void deletarTopico(Long id){
        var topico = repository.findById(id);
        if(topico.isEmpty()){
            throw new ValidacaoException("Nenhum tópico encontrado com esse ID!");
        }
        topico.get().deletar();
    }
}
