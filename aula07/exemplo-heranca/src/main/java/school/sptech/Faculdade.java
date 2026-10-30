package school.sptech;

import java.util.ArrayList;
import java.util.List;


public class Faculdade {
    private String nome;
    private List<Aluno> alunos;

    public Faculdade(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public Double calcularMediaNotasFaculdade(){
        Double total = 0.0;

        for (Aluno aluno : alunos) {
            total += aluno.calcularNotaFinal();
        }

        return total / alunos.size();
    }

    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public Double calcularMediaNotasPos(){
        Double total = 0.0;
        Integer qtdAlunoPos = 0;

        for (Aluno aluno : alunos) {
            if(aluno instanceof AlunoPos alunoPos){
                alunoPos.calcularNotaFinal();
                qtdAlunoPos++;
            }
            total += aluno.calcularNotaFinal();
        }

        return total / qtdAlunoPos;
    }

    public String getNome() {
        return nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return "Faculdade{" +
                "nome='" + nome + '\'' +
                ", alunos=" + alunos +
                '}';
    }
}
