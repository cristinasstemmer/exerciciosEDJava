package filaImpressao;

public class TrabalhoImpressao {
    String descricao;
    TrabalhoImpressao proximo;

    public TrabalhoImpressao(String descricao) {
        this.descricao = descricao;
        this.proximo = null;
    }
}
