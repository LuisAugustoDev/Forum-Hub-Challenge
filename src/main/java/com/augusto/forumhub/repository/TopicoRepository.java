package com.augusto.forumhub.repository;

import com.augusto.forumhub.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByTituloAndMensagem(String titulo, String mensagem);
    Page<Topico> findAllByEstadoTopicoTrue(Pageable page);
}
