package com.financontrol.carteira.model.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.financontrol.carteira.model.dtos.AuthDto;
import com.financontrol.carteira.model.entities.Usuario;
import com.financontrol.carteira.model.repository.UsuarioRepository;
import com.financontrol.carteira.model.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public String Obtertoken(AuthDto authDto) {

        Usuario usuario = usuarioRepository.findByEmail(authDto.email());

        return geraTokenJwt(usuario);
    }

    public String geraTokenJwt(Usuario usuario) {

        try {

            Algorithm algorithm = Algorithm.HMAC256("secret-api");

            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(geraDataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token " + exception.getMessage());
        }
    }

    private Instant geraDataExpiracao() {
        return LocalDateTime.now()
                .plusHours(8)
                .toInstant(ZoneOffset.of("-03:00"));
    }

    public String validaToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret-api");
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }
}
