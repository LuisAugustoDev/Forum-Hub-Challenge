package com.augusto.forumhub.service;

import com.augusto.forumhub.dto.DadosCadastroTopico;
import com.augusto.forumhub.model.Topico;
import com.augusto.forumhub.repository.CursoRepository;
import com.augusto.forumhub.repository.TopicoRepository;
import com.augusto.forumhub.repository.UsuarioRepository;
import com.augusto.forumhub.validacao.ValidacaoTopicoExistente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarTopico {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ValidacaoTopicoExistente validar;

    public Topico cadastrar(DadosCadastroTopico dados){
        var usuario = usuarioRepository.findById(dados.autorId());
        var curso = cursoRepository.findById(dados.cursoId());
        var topico = new Topico(dados);
        if(usuario.isPresent() && curso.isPresent()) {
            topico.setAutor(usuario.get());
            topico.setCurso(curso.get());
        }
        validar.validar(dados);
        return repository.save(topico);
    }
}
