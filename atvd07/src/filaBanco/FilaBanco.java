package filaBanco;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaBanco {
    private Queue<String> fila;

    public FilaBanco() {
        fila = new LinkedList<>();
    }

    public void adicionarCliente(String nome) {
        fila.add(nome);
        System.out.println("Cliente adicionado: " + nome);
    }

    public void chamarProximoCliente() {
        if (fila.isEmpty()) {
            System.out.println("Não há clientes na fila.");
        } else {
            String cliente = fila.poll();
            System.out.println("Cliente chamado: " + cliente);
        }
    }

    public void listarClientes() {
        System.out.println("Clientes na fila:");
        for (String cliente : fila) {
            System.out.println(cliente);
        }
    }

    public static void main(String[] args) {
        FilaBanco filaBanco = new FilaBanco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Adicionar cliente");
            System.out.println("2. Chamar próximo cliente");
            System.out.println("3. Listar clientes");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = scanner.nextLine();
                    filaBanco.adicionarCliente(nomeCliente);
                    break;
                case 2:
                    filaBanco.chamarProximoCliente();
                    break;
                case 3:
                    filaBanco.listarClientes();
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
