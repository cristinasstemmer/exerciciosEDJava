package filaImpressao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GerenciadorImpressao {
    private Queue<String> filaImpressao;

    public GerenciadorImpressao() {
        filaImpressao = new LinkedList<>();
    }

    public void adicionarTrabalho(String descricao) {
        filaImpressao.add(descricao);
        System.out.println("Trabalho de impressão adicionado: " + descricao);
    }

    public void processarTrabalho() {
        if (filaImpressao.isEmpty()) {
            System.out.println("Nenhum trabalho de impressão para processar.");
        } else {
            String trabalho = filaImpressao.poll();
            System.out.println("Trabalho de impressão processado: " + trabalho);
        }
    }

    public void listarTrabalhos() {
        System.out.println("Trabalhos de impressão na fila:");
        for (String trabalho : filaImpressao) {
            System.out.println(trabalho);
        }
    }

    public static void main(String[] args) {
        GerenciadorImpressao gerenciador = new GerenciadorImpressao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Adicionar trabalho de impressão");
            System.out.println("2. Processar trabalho de impressão");
            System.out.println("3. Listar trabalhos de impressão");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a descrição do trabalho de impressão:");
                    String descricaoTrabalho = scanner.nextLine();
                    gerenciador.adicionarTrabalho(descricaoTrabalho);
                    break;
                case 2:
                    gerenciador.processarTrabalho();
                    break;
                case 3:
                    gerenciador.listarTrabalhos();
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