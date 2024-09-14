package historicoNavegacao;

import java.util.Scanner;

public class HistoricoNavegacao {
    private Pagina primeiro;
    private int tamanhoMaximo;
    private int tamanhoAtual;

    public HistoricoNavegacao(int tamanhoMaximo) {
        this.primeiro = null;
        this.tamanhoMaximo = tamanhoMaximo;
        this.tamanhoAtual = 0;
    }

    public void adicionarPagina(String url) {
        if (tamanhoAtual >= tamanhoMaximo) {
            removerPagina();
        }

        Pagina novaPagina = new Pagina(url);
        novaPagina.proxima = primeiro;
        primeiro = novaPagina;
        tamanhoAtual++;
        System.out.println("Página adicionada: " + url);
    }

    public void removerPagina() {
        if (primeiro == null) {
            System.out.println("Não há páginas para remover.");
            return;
        }

        primeiro = primeiro.proxima;
        tamanhoAtual--;
        System.out.println("Página mais antiga removida.");
    }

    public void listarPaginas() {
        Pagina atual = primeiro;
        while (atual != null) {
            System.out.println("URL: " + atual.url);
            atual = atual.proxima;
        }
    }

    public static void main(String[] args) {
        HistoricoNavegacao historico = new HistoricoNavegacao(5); // Limite de 5 URLs
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Adicionar URL");
            System.out.println("2. Remover URL");
            System.out.println("3. Listar URLs");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a URL:");
                    String urlAdicionar = scanner.nextLine();
                    historico.adicionarPagina(urlAdicionar);
                    break;
                case 2:
                    historico.removerPagina();
                    break;
                case 3:
                    System.out.println("Histórico:");
                    historico.listarPaginas();
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
