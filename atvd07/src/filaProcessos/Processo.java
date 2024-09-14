package filaProcessos;

public class Processo {
    String nome;
    Processo proximo;

    public Processo(String nome) {
        this.nome = nome;
        this.proximo = null;
    }
}
