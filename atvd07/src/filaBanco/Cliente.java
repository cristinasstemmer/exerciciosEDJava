package filaBanco;

public class Cliente {
    String nome;
    Cliente proximo;

    public Cliente(String nome) {
        this.nome = nome;
        this.proximo = null;
    }
}