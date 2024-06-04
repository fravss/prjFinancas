package com.financontrol.carteira.model.entities;


import lombok.Getter;

@Getter
public enum Tipo {
    RECEITA(1, "Receita"),
    DESPESA(2, "Despesa");

    private final int id;
    private final String nome;

    Tipo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
