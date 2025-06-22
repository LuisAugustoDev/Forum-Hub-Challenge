package com.augusto.forumhub.service;

import com.augusto.forumhub.infra.exception.ValidacaoException;
import com.augusto.forumhub.model.Topico;
import com.augusto.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalhamentoTopico {

    @Autowired
    private TopicoRepository repository;

    public Topico detalhar(Long id){
        var topico = repository.findById(id);
        if(!topico.isPresent()){
            throw new ValidacaoException("Nenhum tópico encontrado com esse ID");
        }
        return repository.findById(id).get();
    }
}
