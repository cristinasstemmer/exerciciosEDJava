package filaProcessos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GerenciadorProcessos {
    private Queue<String> filaProcessos;

    public GerenciadorProcessos() {
        filaProcessos = new LinkedList<>();
    }

    public void adicionarProcesso(String nome) {
        filaProcessos.add(nome);
        System.out.println("Processo adicionado: " + nome);
    }

    public void executarProcesso() {
        if (filaProcessos.isEmpty()) {
            System.out.println("Nenhum processo para executar.");
        } else {
            String processo = filaProcessos.poll();
            System.out.println("Processo executado: " + processo);
        }
    }

    public void listarProcessos() {
        System.out.println("Processos na fila:");
        for (String processo : filaProcessos) {
            System.out.println(processo);
        }
    }

    public static void main(String[] args) {
        GerenciadorProcessos gerenciador = new GerenciadorProcessos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Adicionar processo");
            System.out.println("2. Executar processo");
            System.out.println("3. Listar processos");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do processo:");
                    String nomeProcesso = scanner.nextLine();
                    gerenciador.adicionarProcesso(nomeProcesso);
                    break;
                case 2:
                    gerenciador.executarProcesso();
                    break;
                case 3:
                    gerenciador.listarProcessos();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
