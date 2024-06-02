package com.financontrol.carteira.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping
    public String index() {
        return "redirect:auth";
    }

    @GetMapping("auth")
    public String auth() {
        return "logincadastro";
    }

    @GetMapping("login")
    public String login() {
        return "redirect:/home";
    }

    @GetMapping("cadastrar")
    public String cadastrar() {
        return "redirect:/auth";
    }
}
