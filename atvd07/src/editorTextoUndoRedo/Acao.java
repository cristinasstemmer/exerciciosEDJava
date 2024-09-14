package editorTextoUndoRedo;

public class Acao {
    String descricao;
    Acao anterior;
    Acao proxima;

    public Acao(String descricao) {
        this.descricao = descricao;
        this.anterior = null;
        this.proxima = null;
    }
}