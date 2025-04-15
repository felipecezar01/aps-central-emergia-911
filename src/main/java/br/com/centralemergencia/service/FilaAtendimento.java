package br.com.centralemergencia.service;

import br.com.centralemergencia.model.Chamado;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FilaAtendimento {
    private final PriorityQueue<Chamado> fila;

    public FilaAtendimento() {
        this.fila = new PriorityQueue<>(Comparator.comparingInt(c -> c.getPrioridade().getNivel()));
    }

    public void adicionarChamado(Chamado chamado) {
        fila.offer(chamado);
    }

    public Chamado atenderChamado() {
        return fila.poll();
    }

    public boolean filaVazia() {
        return fila.isEmpty();
    }

    public PriorityQueue<Chamado> getFila() {
        return new PriorityQueue<>(fila); // Cópia para leitura
    }
}
