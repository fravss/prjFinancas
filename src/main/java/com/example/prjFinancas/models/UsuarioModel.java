package com.example.prjFinancas.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name="TB_USUARIO")
public class UsuarioModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<LancamentoModel> lancamentos;

    private String nome;
    private String email;
    private String senha;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<LancamentoModel> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<LancamentoModel> lancamentos) {
        this.lancamentos = lancamentos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
