package br.com.centralemergencia;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Simula um usuário real:
 *  • envia comandos linha a linha
 *  • ecoa cada comando no console no momento em que é “digitado”
 */
public class InteractiveScriptRunner {

    /* Sequência exata de entradas que seriam digitadas */
    private static final List<String> COMANDOS = List.of(
            // --- Registrar 3 chamados ---
            "1",  "Acidente com feridos", "2",          // prioridade 2
            "1",  "Furto simples",        "4",          // prioridade 4
            "1",  "Incêndio",             "1",          // prioridade 1
            // --- Listar fila cheia ---
            "2",
            // --- Atender 3 chamados ---
            "3", "3", "3",
            // --- Listar fila vazia ---
            "2",
            // --- Sair ---
            "4"
    );

    public static void main(String[] args) throws Exception {

        /* 1. Canal que vira o System.in do Main */
        PipedInputStream  pipeIn  = new PipedInputStream();
        PipedOutputStream pipeOut = new PipedOutputStream(pipeIn);
        System.setIn(pipeIn);

        /* 2. Thread que “digita” e ecoa */
        Thread simulador = new Thread(() -> {
            try (pipeOut) {
                Thread.sleep(300);                    // espera menu inicial
                for (String linha : COMANDOS) {
                    System.out.println(linha);        // ECO
                    pipeOut.write((linha + "\n").getBytes(StandardCharsets.UTF_8));
                    pipeOut.flush();
                    Thread.sleep(200);                // ritmo
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        simulador.start();

        /* 3. Executa o programa */
        Main.main(new String[0]);

        simulador.join();
    }
}
