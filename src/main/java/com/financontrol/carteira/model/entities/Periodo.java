package com.financontrol.carteira.model.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
public enum Periodo {
    UNICO(1, "Único"),
    SEMANAL(2, "Semanal"),
    QUINZENAL(3, "Quinzenal"),
    MENSAL(4, "Mensal"),
    SEMESTRAL(5, "Semestral"),
    ANUAL(6, "Anual");

    private final int id;
    private final String nome;

    Periodo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
