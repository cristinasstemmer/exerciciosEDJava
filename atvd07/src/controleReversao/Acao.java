package controleReversao;

public class Acao {
    String descricao;
    Acao proxima;

    public Acao(String descricao) {
        this.descricao = descricao;
        this.proxima = null;
    }
}
