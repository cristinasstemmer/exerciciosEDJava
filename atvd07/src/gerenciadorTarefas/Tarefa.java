package gerenciadorTarefas;

public class Tarefa {
    String descricao;
    boolean concluida;
    Tarefa proxima;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
        this.proxima = null;
    }
}
