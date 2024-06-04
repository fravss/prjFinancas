package com.financontrol.carteira.model.repository;

import com.financontrol.carteira.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Usuario findByEmail(String email);
}
