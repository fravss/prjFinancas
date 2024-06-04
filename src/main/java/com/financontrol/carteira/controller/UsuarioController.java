package com.financontrol.carteira.controller;

import com.financontrol.carteira.model.dtos.UsuarioDto;
import com.financontrol.carteira.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//RECEBER AS REQUISIÇÕES HTTP ATRIBUIDO À USUÁRIO
@RestController
@RequestMapping("/cadastrar") //Requisição para esse controlador
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    private UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto) {
        return usuarioService.salvar(usuarioDto);
    }
}
