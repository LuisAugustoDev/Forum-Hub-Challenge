package com.augusto.forumhub.controller;

import com.augusto.forumhub.dto.DadosAtualizacaoTopico;
import com.augusto.forumhub.dto.DadosCadastroTopico;
import com.augusto.forumhub.dto.DadosDetalhamentoTopico;
import com.augusto.forumhub.dto.DadosRetornoTopico;
import com.augusto.forumhub.model.Topico;
import com.augusto.forumhub.service.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private CadastrarTopico cadastrar;

    @Autowired
    private ListagemTopico listagem;

    @Autowired
    private DetalhamentoTopico detalhamentoTopico;

    @Autowired
    private AtualizarTopico atualizarTopico;

    @Autowired
    private DeletarTopico deletarTopico;

    @PostMapping
    @Transactional
    public ResponseEntity cadastraTopico(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
        var topico = cadastrar.cadastrar(dados);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosRetornoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosRetornoTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = listagem.listarTopicos(paginacao).map(DadosRetornoTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = detalhamentoTopico.detalhar(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados){
        var topico = atualizarTopico.atualizar(dados);
        return ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        deletarTopico.deletarTopico(id);
        return ResponseEntity.noContent().build();
    }

}
