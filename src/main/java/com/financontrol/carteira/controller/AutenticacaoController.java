package com.financontrol.carteira.controller;

import com.financontrol.carteira.model.dtos.AuthDto;
import com.financontrol.carteira.model.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public String autenticar(@RequestBody AuthDto authDto) {

        var usuarioAutenticationToken = new UsernamePasswordAuthenticationToken(authDto.email(), authDto.senha());

        authenticationManager.authenticate(usuarioAutenticationToken);

        return autenticacaoService.Obtertoken(authDto);
    }

    @GetMapping
    public String logincadastro() {
        return "logincadastro";
    }
}
