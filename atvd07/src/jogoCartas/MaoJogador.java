package jogoCartas;

import java.util.Scanner;

public class MaoJogador {
    private Carta primeiro;
    private Carta ultimo;

    public MaoJogador() {
        primeiro = null;
        ultimo = null;
    }

    public void adicionarCarta(String valor) {
        Carta novaCarta = new Carta(valor);
        if (ultimo == null) {
            primeiro = novaCarta;
            ultimo = novaCarta;
        } else {
            ultimo.proxima = novaCarta;
            novaCarta.anterior = ultimo;
            ultimo = novaCarta;
        }
        System.out.println("Carta adicionada: " + valor);
    }

    public void removerCarta(String valor) {
        Carta atual = primeiro;
        while (atual != null && !atual.valor.equals(valor)) {
            atual = atual.proxima;
        }

        if (atual == null) {
            System.out.println("Carta não encontrada: " + valor);
            return;
        }

        if (atual.anterior != null) {
            atual.anterior.proxima = atual.proxima;
        } else {
            primeiro = atual.proxima;
        }

        if (atual.proxima != null) {
            atual.proxima.anterior = atual.anterior;
        } else {
            ultimo = atual.anterior;
        }

        System.out.println("Carta removida: " + valor);
    }

    public void reorganizarCartas(String valor, int posicao) {

        System.out.println("Reorganização não implementada.");
    }

    public void listarCartas() {
        Carta atual = primeiro;
        while (atual != null) {
            System.out.println("Carta: " + atual.valor);
            atual = atual.proxima;
        }
    }

    public static void main(String[] args) {
        MaoJogador mao = new MaoJogador();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Adicionar carta");
            System.out.println("2. Remover carta");
            System.out.println("3. Reorganizar cartas");
            System.out.println("4. Listar cartas");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor da carta:");
                    String cartaAdicionar = scanner.nextLine();
                    mao.adicionarCarta(cartaAdicionar);
                    break;
                case 2:
                    System.out.println("Digite o valor da carta para remover:");
                    String cartaRemover = scanner.nextLine();
                    mao.removerCarta(cartaRemover);
                    break;
                case 3:
                    System.out.println("Digite o valor da carta para reorganizar:");
                    String cartaReorganizar = scanner.nextLine();
                    System.out.println("Digite a nova posição:");
                    int posicao = scanner.nextInt();
                    scanner.nextLine();
                    mao.reorganizarCartas(cartaReorganizar, posicao);
                    break;
                case 4:
                    System.out.println("Cartas:");
                    mao.listarCartas();
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
