package com.financontrol.carteira.model.service.impl;


import com.financontrol.carteira.model.dtos.UsuarioDto;
import com.financontrol.carteira.model.entities.Usuario;
import com.financontrol.carteira.model.repository.UsuarioRepository;
import com.financontrol.carteira.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


//Mapeamento regras de negócio
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository; //Operações com o banco de dados
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto salvar(UsuarioDto usuarioDto) {

        Usuario usuarioJaExiste = usuarioRepository.findByEmail(usuarioDto.email());

        if(usuarioJaExiste != null) {
            throw new RuntimeException("Usuario já existe!");
        }

        var passwordHash = passwordEncoder.encode(usuarioDto.senha());

        Usuario entity = new Usuario(usuarioDto.nome(), usuarioDto.email(), passwordHash);
        Usuario novoUsuario = usuarioRepository.save(entity);

        return new UsuarioDto(novoUsuario.getNome(), novoUsuario.getEmail(), novoUsuario.getSenha());
    }
}
