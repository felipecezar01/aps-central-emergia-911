package br.com.centralemergencia.model;

public enum Prioridade {
    GRAVE(1),
    URGENTE(2),
    MODERADA(3),
    LEVE(4),
    IRRELEVANTE(5);

    private final int nivel;

    Prioridade(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}

