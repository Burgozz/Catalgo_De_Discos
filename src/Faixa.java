public class Faixa {
    private String nome;
    private int duracao; 

    public Faixa(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return nome + " (" + duracao + " segundos)";
    }
}