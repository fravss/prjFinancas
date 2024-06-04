package com.financontrol.carteira.model.service;

import com.financontrol.carteira.model.dtos.AuthDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AutenticacaoService extends UserDetailsService {

    public String Obtertoken(AuthDto authDto);

    public String validaToken(String token);
}
