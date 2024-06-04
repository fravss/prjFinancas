package com.financontrol.carteira.config;


import com.financontrol.carteira.model.repository.UsuarioRepository;
import com.financontrol.carteira.model.service.AutenticacaoService;
import com.financontrol.carteira.model.entities.Usuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extrairTokenHeader(request);

        if (token != null) {
            String email = autenticacaoService.validaToken(token) ;
            Usuario usuario = usuarioRepository.findByEmail(email);

            var autentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(autentication);
        }
    }

    public String extrairTokenHeader(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");

        if (authHeader == null) {
            return null;
        }

        if (authHeader.split(" ")[0].equals("Bearer")) {
            return null;
        }

        return authHeader.split(" ")[1];
    }
}
