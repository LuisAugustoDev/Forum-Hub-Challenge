package com.augusto.forumhub.service;

import com.augusto.forumhub.model.Topico;
import com.augusto.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ListagemTopico {

    @Autowired
    TopicoRepository repository;

    public Page<Topico> listarTopicos(Pageable page){
        var listaTopicos = repository.findAllByEstadoTopicoTrue(page);
        return listaTopicos;
    }
}
