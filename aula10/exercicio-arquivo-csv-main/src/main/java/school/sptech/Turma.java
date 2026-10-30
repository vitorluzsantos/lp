package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nome;
    private List<Aluno> alunos;

    public Turma(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno){
        Boolean raInvalido = false;
        if(aluno == null || aluno.getRa() == null || aluno.getRa().isBlank()){
            return;
        }
        else{
            for (Aluno alunoDaVez : alunos) {
                if(aluno.getRa() == alunoDaVez.getRa()){
                    raInvalido = true;
                }
            }
            if(raInvalido == false){
                alunos.add(aluno);
            }
        }

    }

    public Double calcularMediaGeral(){
        Double soma = 0.0;
        if(alunos == null || alunos.isEmpty()){
            return 0.0;
        }
        for (Aluno aluno : alunos) {
            soma = soma + aluno.calcularMedia();
        }
        Double mediaGeral = soma / alunos.size();
        return mediaGeral;
    }

    public Aluno buscarAlunoMaiorMedia(){
        if(alunos == null || alunos.isEmpty()){
            return null;
        }
        Aluno maiorMedia = alunos.getFirst();
        for (Aluno aluno : alunos) {
            if(aluno.calcularMedia() > maiorMedia.calcularMedia()){
                maiorMedia = aluno;
            }
        }
        return maiorMedia;
    }

    public List<Aluno> filtrarPorSituacao(String situacao){
        List<Aluno> listaAlunos = new ArrayList<>();

        if(situacao.equalsIgnoreCase("APROVADO")){
            for (Aluno aluno : alunos) {
                if(aluno.calcularSituacao() == "APROVADO"){
                    listaAlunos.add(aluno);
                }
            }
        }
        if(situacao.equalsIgnoreCase("RECUPERACAO")){
            for (Aluno aluno : alunos) {
                if(aluno.calcularSituacao() == "RECUPERACAO"){
                    listaAlunos.add(aluno);
                }
            }
        }
        if(situacao.equalsIgnoreCase("REPROVADO")){
            for (Aluno aluno : alunos) {
                if(aluno.calcularSituacao() == "REPROVADO"){
                    listaAlunos.add(aluno);
                }
            }
        }
        return listaAlunos;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "nome='" + nome + '\'' +
                ", alunos=" + alunos +
                '}';
    }
}