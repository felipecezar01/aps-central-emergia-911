package br.com.centralemergencia.model;

public class Chamado {
    private String descricao;
    private Prioridade prioridade;

    public Chamado(String descricao, Prioridade prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    @Override
    public String toString() {
        return "[PRIORIDADE " + prioridade.getNivel() + "] " + prioridade.name() +
                " — \"" + descricao + "\"";
    }
}
