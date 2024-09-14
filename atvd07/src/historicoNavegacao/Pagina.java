package historicoNavegacao;

public class Pagina {
    String url;
    Pagina proxima;

    public Pagina(String url) {
        this.url = url;
        this.proxima = null;
    }
}