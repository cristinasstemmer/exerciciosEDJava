package gerenciadorTarefas;

import java.util.Scanner;

public class GerenciadorTarefas {
    private Tarefa primeiro;
    private Tarefa ultimo;

    public GerenciadorTarefas() {
        primeiro = null;
        ultimo = null;
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        if (primeiro == null) {
            primeiro = novaTarefa;
            ultimo = novaTarefa;
        } else {
            ultimo.proxima = novaTarefa;
            ultimo = novaTarefa;
        }
        System.out.println("Tarefa adicionada: " + descricao);
    }

    public void removerTarefa(String descricao) {
        Tarefa atual = primeiro;
        Tarefa anterior = null;

        while (atual != null && !atual.descricao.equals(descricao)) {
            anterior = atual;
            atual = atual.proxima;
        }

        if (atual == null) {
            System.out.println("Tarefa não encontrada: " + descricao);
            return;
        }

        if (anterior == null) {
            primeiro = atual.proxima;
        } else {
            anterior.proxima = atual.proxima;
        }

        if (atual == ultimo) {
            ultimo = anterior;
        }

        System.out.println("Tarefa removida: " + descricao);
    }

    public void marcarComoConcluida(String descricao) {
        Tarefa atual = primeiro;
        while (atual != null) {
            if (atual.descricao.equals(descricao)) {
                atual.concluida = true;
                System.out.println("Tarefa marcada como concluída: " + descricao);
                return;
            }
            atual = atual.proxima;
        }
        System.out.println("Tarefa não encontrada: " + descricao);
    }

    public void listarTarefas() {
        Tarefa atual = primeiro;
        while (atual != null) {
            System.out.println("Tarefa: " + atual.descricao + " | Concluída: " + atual.concluida);
            atual = atual.proxima;
        }
    }

    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Listar tarefas");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a tarefa:");
                    String tarefaAdicionar = scanner.nextLine();
                    gerenciador.adicionarTarefa(tarefaAdicionar);
                    break;
                case 2:
                    System.out.println("Digite a tarefa para remover:");
                    String tarefaRemover = scanner.nextLine();
                    gerenciador.removerTarefa(tarefaRemover);
                    break;
                case 3:
                    System.out.println("Digite a tarefa para marcar como concluída:");
                    String tarefaConcluir = scanner.nextLine();
                    gerenciador.marcarComoConcluida(tarefaConcluir);
                    break;
                case 4:
                    System.out.println("Tarefas:");
                    gerenciador.listarTarefas();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
