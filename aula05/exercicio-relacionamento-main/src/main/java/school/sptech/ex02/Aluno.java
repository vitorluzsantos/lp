package school.sptech.ex02;

public class Aluno {
    private String nome;
    private Integer idade;
    private String matricula;
    private Double notaProva;
    private Double notaAtividade;

    public Aluno(String nome, Integer idade, String matricula, Double notaProva, Double notaAtividade) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.notaProva = notaProva;
        this.notaAtividade = notaAtividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getNotaProva() {
        return notaProva;
    }

    public void setNotaProva(Double notaProva) {
        this.notaProva = notaProva;
    }

    public Double getNotaAtividade() {
        return notaAtividade;
    }

    public void setNotaAtividade(Double notaAtividade) {
        this.notaAtividade = notaAtividade;
    }

    public Double calcularNotaFinal(){
        return (notaProva * 0.7) + (notaAtividade * 0.3);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", matricula='" + matricula + '\'' +
                ", notaProva=" + notaProva +
                ", notaAtividade=" + notaAtividade +
                '}';
    }
}
