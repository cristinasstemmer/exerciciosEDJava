package jogoCartas;

public class Carta {
    String valor;
    Carta anterior;
    Carta proxima;

    public Carta(String valor) {
        this.valor = valor;
        this.anterior = null;
        this.proxima = null;
    }
}
