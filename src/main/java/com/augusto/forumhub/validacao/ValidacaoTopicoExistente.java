package com.augusto.forumhub.validacao;

import com.augusto.forumhub.dto.DadosCadastroTopico;
import com.augusto.forumhub.infra.exception.ValidacaoException;
import com.augusto.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTopicoExistente {

    @Autowired
    private TopicoRepository repository;

    public void validar(DadosCadastroTopico dados){
        var topico = repository.findByTituloAndMensagem(dados.titulo(), dados.mensagem());
        if(!topico.isEmpty()){
            throw new ValidacaoException("Já existe um tópico com este título ou mensagem");
        }
    }
}
