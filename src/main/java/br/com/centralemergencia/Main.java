package br.com.centralemergencia;

import br.com.centralemergencia.model.Chamado;
import br.com.centralemergencia.model.Prioridade;
import br.com.centralemergencia.service.FilaAtendimento;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FilaAtendimento fila = new FilaAtendimento();

    public static void main(String[] args) {
        int opcao;

        do {
            mostrarMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> registrarChamado();
                case 2 -> listarFila();
                case 3 -> atenderChamado();
                case 4 -> encerrarSistema();
                default -> System.out.println("⚠️  Opção inválida. Tente novamente.");
            }

        } while (opcao != 4);
    }

    private static void mostrarMenu() {
        System.out.println("\n===============================");
        System.out.println("🛑 CENTRAL DE EMERGÊNCIA 911 🛑");
        System.out.println("===============================");
        System.out.println("1. Registrar novo chamado");
        System.out.println("2. Ver fila de chamados");
        System.out.println("3. Atender próximo chamado");
        System.out.println("4. Sair do sistema");
        System.out.println("===============================");
    }

    private static void registrarChamado() {
        System.out.print("Digite a descrição do chamado: ");
        String descricao = scanner.nextLine();

        System.out.println("Selecione o nível de prioridade:");
        for (Prioridade p : Prioridade.values()) {
            System.out.printf("%d. %s%n", p.getNivel(), p.name());
        }

        int nivel = lerInteiro("Escolha: ");
        Prioridade prioridade = encontrarPrioridadePorNivel(nivel);

        if (prioridade != null) {
            Chamado chamado = new Chamado(descricao, prioridade);
            fila.adicionarChamado(chamado);
            System.out.println("✅ Chamado registrado com sucesso!");
        } else {
            System.out.println("⚠️  Prioridade inválida. Chamado não registrado.");
        }
    }

    private static Prioridade encontrarPrioridadePorNivel(int nivel) {
        for (Prioridade p : Prioridade.values()) {
            if (p.getNivel() == nivel) return p;
        }
        return null;
    }

    private static void listarFila() {
        System.out.println("\n=== FILA DE CHAMADOS (ordem de prioridade) ===");

        if (fila.filaVazia()) {
            System.out.println("Nenhum chamado na fila.");
        } else {
            int i = 1;
            for (Chamado chamado : fila.getFila()) {
                System.out.printf("%d. %s%n", i++, chamado);
            }
        }
    }

    private static void atenderChamado() {
        if (fila.filaVazia()) {
            System.out.println("Nenhum chamado para atender.");
        } else {
            Chamado chamado = fila.atenderChamado();
            System.out.println("\n🔔 Chamado atendido:");
            System.out.println(chamado);
        }
    }

    private static void encerrarSistema() {
        System.out.println("Sistema encerrado. Até logo!");
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.next(); // descarta entrada inválida
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpa o buffer
        return valor;
    }
}

