package controleReversao;

import java.util.Scanner;

public class ControleReversao {
    private Acao topo;
    private Acao undoTopo;

    public ControleReversao() {
        topo = null;
        undoTopo = null;
    }

    public void adicionarAcao(String descricao) {
        Acao novaAcao = new Acao(descricao);
        novaAcao.proxima = topo;
        topo = novaAcao;
        System.out.println("Ação adicionada: " + descricao);
    }

    public void desfazerAcao() {
        if (topo == null) {
            System.out.println("Nenhuma ação para desfazer.");
            return;
        }

        Acao acaoDesfeita = topo;
        topo = topo.proxima;
        acaoDesfeita.proxima = undoTopo;
        undoTopo = acaoDesfeita;

        System.out.println("Ação desfeita: " + acaoDesfeita.descricao);
    }

    public void refazerAcao() {
        if (undoTopo == null) {
            System.out.println("Nenhuma ação para refazer.");
            return;
        }

        Acao acaoRefazer = undoTopo;
        undoTopo = undoTopo.proxima;
        acaoRefazer.proxima = topo;
        topo = acaoRefazer;

        System.out.println("Ação refeita: " + acaoRefazer.descricao);
    }

    public void listarAcoes() {
        Acao atual = topo;
        while (atual != null) {
            System.out.println("Ação: " + atual.descricao);
            atual = atual.proxima;
        }
    }

    public static void main(String[] args) {
        ControleReversao controle = new ControleReversao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Adicionar ação");
            System.out.println("2. Desfazer ação");
            System.out.println("3. Refazer ação");
            System.out.println("4. Listar ações");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a ação:");
                    String acaoAdicionar = scanner.nextLine();
                    controle.adicionarAcao(acaoAdicionar);
                    break;
                case 2:
                    controle.desfazerAcao();
                    break;
                case 3:
                    controle.refazerAcao();
                    break;
                case 4:
                    System.out.println("Ações:");
                    controle.listarAcoes();
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

