package com.financontrol.carteira.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_LANCAMENTO")
public class Lancamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codigo;

    private float valor;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Periodo periodo;
    @Column(nullable = false)
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
