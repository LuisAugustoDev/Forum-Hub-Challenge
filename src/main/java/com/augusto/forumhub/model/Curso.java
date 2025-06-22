package com.augusto.forumhub.model;

import com.augusto.forumhub.dto.DadosCurso;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cursos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "curso")
    @JsonBackReference
    private List<Topico> topicos;

    public Curso(DadosCurso dados){
        this.nome = dados.nome();
    }
}
