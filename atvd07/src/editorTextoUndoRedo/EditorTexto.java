package editorTextoUndoRedo;

import java.util.Scanner;

public class EditorTexto {
    private Acao topo;
    private Acao redoTopo;

    public EditorTexto() {
        topo = null;
        redoTopo = null;
    }

    public void adicionarAcao(String descricao) {
        Acao novaAcao = new Acao(descricao);
        if (topo != null) {
            topo.proxima = novaAcao;
            novaAcao.anterior = topo;
        }
        topo = novaAcao;
        redoTopo = null;
        System.out.println("Ação adicionada: " + descricao);
    }

    public void desfazerAcao() {
        if (topo == null) {
            System.out.println("Nenhuma ação para desfazer.");
            return;
        }

        Acao acaoDesfeita = topo;
        topo = topo.anterior;
        if (topo != null) {
            topo.proxima = null;
        }

        acaoDesfeita.proxima = redoTopo;
        redoTopo = acaoDesfeita;

        System.out.println("Ação desfeita: " + acaoDesfeita.descricao);
    }

    public void refazerAcao() {
        if (redoTopo == null) {
            System.out.println("Nenhuma ação para refazer.");
            return;
        }

        Acao acaoRefazer = redoTopo;
        redoTopo = redoTopo.proxima;
        if (redoTopo != null) {
            redoTopo.anterior = null;
        }

        acaoRefazer.proxima = topo;
        if (topo != null) {
            topo.anterior = acaoRefazer;
        }
        topo = acaoRefazer;

        System.out.println("Ação refeita: " + acaoRefazer.descricao);
    }

    public void listarAcoes() {
        Acao atual = topo;
        while (atual != null) {
            System.out.println("Ação: " + atual.descricao);
            atual = atual.anterior;
        }
    }

    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
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
                    editor.adicionarAcao(acaoAdicionar);
                    break;
                case 2:
                    editor.desfazerAcao();
                    break;
                case 3:
                    editor.refazerAcao();
                    break;
                case 4:
                    System.out.println("Ações:");
                    editor.listarAcoes();
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
