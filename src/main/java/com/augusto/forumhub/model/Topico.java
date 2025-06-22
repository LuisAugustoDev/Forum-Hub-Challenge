package com.augusto.forumhub.model;

import com.augusto.forumhub.dto.DadosAtualizacaoTopico;
import com.augusto.forumhub.dto.DadosCadastroTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private Boolean estadoTopico;
    private LocalDateTime dataCriacao;
    private Long autorId;
    private Long cursoId;

    public Topico(DadosCadastroTopico dados){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.estadoTopico = true;
        this.dataCriacao = LocalDateTime.now();
        this.autorId = dados.autor_id();
        this.cursoId = dados.curso_id();
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados){
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if(dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if(dados.estadoTopico() != null) {
            this.estadoTopico = dados.estadoTopico();
        }
        if(dados.autorId() != null) {
            this.autorId = dados.autorId();
        }
        if(dados.cursoId() != null) {
            this.cursoId = dados.cursoId();
        }
    }

    public void deletar(){
        this.estadoTopico = false;
    }

}
