package com.augusto.forumhub.service;

import com.augusto.forumhub.dto.DadosCadastroTopico;
import com.augusto.forumhub.model.Topico;
import com.augusto.forumhub.repository.TopicoRepository;
import com.augusto.forumhub.validacao.ValidacaoTopicoExistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarTopico {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private ValidacaoTopicoExistente validar;

    public Topico cadastrar(DadosCadastroTopico dados){
        var topico = new Topico(dados);
        validar.validar(dados);
        return repository.save(topico);
    }
}
