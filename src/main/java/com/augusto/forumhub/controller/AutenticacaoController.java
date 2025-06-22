package com.augusto.forumhub.controller;

import com.augusto.forumhub.dto.DadosAutenticacao;
import com.augusto.forumhub.dto.DadosTokenJWT;
import com.augusto.forumhub.infra.security.TokenService;
import com.augusto.forumhub.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody DadosAutenticacao dados){
       var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
       var authentication = manager.authenticate(authenticationToken);

       var tokenJWT = tokenService.gerarTokenJWT((Usuario) authentication.getPrincipal());

       return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}
