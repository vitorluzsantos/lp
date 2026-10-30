package school.sptech;

public class Produto {
    protected Double peso;
    protected Double preco;
    protected String nome;

    public Double calcularFrete(){
        return 2.0 * peso;
    }

    public Double calcularPrecoFinal(){
        return this.preco + calcularFrete();
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "peso=" + peso +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                '}';
    }
}
