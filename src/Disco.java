import java.util.ArrayList;

public class Disco {
    private String titulo;
    private int ano;
    private Artista artista;
    private ArrayList<Faixa> faixas;

    public Disco(String titulo, int ano, Artista artista) {
        this.titulo = titulo;
        this.ano = ano;
        this.artista = artista;
        this.faixas = new ArrayList<>();
    }

    public void adicionarFaixa(Faixa faixa) {
        faixas.add(faixa);
    }

    public String getTitulo() {
        return titulo;
    }

    public void editar(String novoTitulo) {
        this.titulo = novoTitulo;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Disco: ").append(titulo)
            .append(", Ano: ").append(ano)
            .append("\n").append(artista)
            .append("\nFaixas:\n");
        for (Faixa faixa : faixas) {
            info.append("- ").append(faixa).append("\n");
        }
        return info.toString();
    }
}