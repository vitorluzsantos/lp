package ex02;

import java.util.List;

public class Secretaria {
    private Integer totalInadimplentes;
    private Integer totalCancelamentos;
    private Integer totalPagamentos;

    public Secretaria() {
        this.totalInadimplentes = 0;
        this.totalCancelamentos = 0;
        this.totalPagamentos = 0;
    }

    public Integer getTotalInadimplentes() {
        return totalInadimplentes;
    }

    public Integer getTotalCancelamentos() {
        return totalCancelamentos;
    }

    public Integer getTotalPagamentos() {
        return totalPagamentos;
    }

    public void registraPagamento(Aluno aluno){
        aluno.setQtdMesesInadimplente(0);
        this.totalPagamentos++;
    }

    public void registraInadimplencia(Aluno aluno){
        aluno.setQtdMesesInadimplente(aluno.getQtdMesesInadimplente() + 1);
        this.totalInadimplentes++;
    }

    public Boolean registraCancelamento(Aluno aluno){
        if(aluno.getQtdMesesInadimplente() >= 3){
            aluno.setAtivo(false);
            this.totalCancelamentos++;
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean verificaAprovacaoAluno(Aluno aluno){
        if(aluno.getAtivo() && aluno.getQtdMesesInadimplente() == 0 && aluno.calcularMedia() >= 6){
            return true;
        }
        else{
            return false;
        }
    }

    public Double calcularMediaGeralTurma(List<Aluno> alunos){
        Double soma = 0.0;
        Integer quantidade = 0;
        for (Aluno aluno : alunos) {
            if(aluno.getAtivo()){
                soma = soma + aluno.calcularMedia();
                quantidade++;
            }
        }
        if(soma > 0.0){
            return soma / quantidade;
        }
        else {
            return 0.0;
        }
    }

    public Double calcularPercentualInadimplencia(List<Aluno> alunos){
        if(alunos.size() == 0){
            return 0.0;
        }
        Integer quantidade = 0;
        for (Aluno aluno : alunos) {
            if(aluno.getQtdMesesInadimplente() > 0){
                quantidade++;
            }
        }
        if(quantidade > 0){
            return (double) ((quantidade * 100)/alunos.size());
        }
        else{
            return 0.0;
        }
    }

    public Double calcularDesvioPadraoTurma(List<Aluno> alunos){
        Double soma = 0.0;
        Integer alunosAtivos = 0;
        if(alunos.size() > 0){
            for (Aluno aluno : alunos) {
                if(aluno.getAtivo()){
                    soma = soma + aluno.calcularMedia();
                    alunosAtivos++;
                }
            }
            if(alunosAtivos > 0){
                Double mediaTurma = soma /alunos.size();
                Double somaDosQuadrados = 0.0;
                for (Aluno aluno : alunos) {
                    if(aluno.getAtivo()){
                        Double mediaAluno = aluno.calcularMedia();
                        Double diferenca = mediaAluno - mediaTurma;
                        somaDosQuadrados += diferenca * diferenca;
                    }
                }
                Double variancia = somaDosQuadrados / alunosAtivos;
                Double desvioPadrao = Math.sqrt(variancia);
                return desvioPadrao;
            }
        }
        return 0.0;
    }

}
