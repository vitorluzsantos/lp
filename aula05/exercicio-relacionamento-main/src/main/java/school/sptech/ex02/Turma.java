package school.sptech.ex02;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nome;
    private List<Aluno> alunos;

    public Turma(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public void matricular(Aluno aluno) {
        if (!alunoValido(aluno)) {
            System.out.println("aluno inválido");
            return;
        }
        this.alunos.add(aluno);
    }

    private boolean alunoValido(Aluno aluno) {
        if (aluno == null) return false;
        if (aluno.getNome() == null || aluno.getNome().isBlank()) return false;
        if (aluno.getIdade() == null || aluno.getIdade() < 0) return false;
        if (aluno.getNotaProva() == null || aluno.getNotaProva() < 0.0 || aluno.getNotaProva() > 10.0) return false;
        if (aluno.getNotaAtividade() == null || aluno.getNotaAtividade() < 0.0 || aluno.getNotaAtividade() > 10.0) return false;
        return true;
    }

    public List<Aluno> buscarPorParteDoNome(String nome) {
        List<Aluno> encontrados = new ArrayList<>();
        if (nome == null) return encontrados;

        String buscaLower = nome.toLowerCase();
        for (Aluno aluno : alunos) {
            if (aluno.getNome() != null && aluno.getNome().toLowerCase().contains(buscaLower)) {
                encontrados.add(aluno);
            }
        }
        return encontrados;
    }

    public List<Aluno> buscarAprovados(Double notaMinima) {
        List<Aluno> aprovados = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.calcularNotaFinal() >= notaMinima - 0.0001) {
                aprovados.add(aluno);
            }
        }
        return aprovados;
    }

    public Double calcularMediaTurma() {
        if (alunos.isEmpty()) return 0.0;
        double soma = 0.0;
        for (Aluno aluno : alunos) {
            soma += aluno.calcularNotaFinal();
        }
        return soma / alunos.size();
    }

    public List<Aluno> buscarAcimaDaMedia() {
        Double media = calcularMediaTurma();
        List<Aluno> acimaDaMedia = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.calcularNotaFinal() > media) {
                acimaDaMedia.add(aluno);
            }
        }
        return acimaDaMedia;
    }

    public Aluno buscarMenorNota() {
        if (alunos.isEmpty()) return null;

        Aluno menor = alunos.get(0);
        for (Aluno aluno : alunos) {
            if (aluno.calcularNotaFinal() < menor.calcularNotaFinal()) {
                menor = aluno;
            }
        }
        return menor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Double calcularIdadeMedia(){
        Double soma = 0.0;
        if(this.alunos.size() == 0){
            return 0.0;
        }else{
            for (Aluno aluno : alunos) {
                soma = soma + aluno.getIdade();
            }
            Double media = soma / this.alunos.size();
            return media;
        }
    }

    public Double calcularAmplitudeNotas() {
        if (alunos.isEmpty()) return 0.0;

        double maior = alunos.get(0).calcularNotaFinal();
        double menor = alunos.get(0).calcularNotaFinal();

        for (Aluno aluno : alunos) {
            double nota = aluno.calcularNotaFinal();
            if (nota > maior) maior = nota;
            if (nota < menor) menor = nota;
        }

        return maior - menor;
    }

    public List<Aluno> encontrarAlunosComMesmaNota() {
        List<Aluno> resultado = new ArrayList<>();

        for (int i = 0; i < alunos.size(); i++) {
            for (int j = 0; j < alunos.size(); j++) {
                if (i != j && alunos.get(i).calcularNotaFinal().equals(alunos.get(j).calcularNotaFinal())) {
                    if (!resultado.contains(alunos.get(i))) {
                        resultado.add(alunos.get(i));
                    }
                    break;
                }
            }
        }

        return resultado;
    }
}