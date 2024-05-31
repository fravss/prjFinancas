package com.example.prjFinancas.models;


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

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
