package school.sptech.ex4;

public class Turma {

    String turma;
    Integer capacidadeMaxima;
    Integer quantidadeAlunosMatriculados;

    void matricularAluno(Integer quantidadeAlunos){
        if(quantidadeAlunos > 0){
            if(quantidadeAlunos + quantidadeAlunosMatriculados <= capacidadeMaxima){
                quantidadeAlunosMatriculados += quantidadeAlunos;
            }
        }
    }

    Double encontrarMaiorNota(Double[] notas){
        Double maiorNota = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if(maiorNota < notas[i]){
                maiorNota = notas[i];
            }
        }
        return maiorNota;
    }

    Double calcularMediaTurma(Double[] notas){
        Double soma = 0.0;
        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }

        return soma / notas.length;
    }

    Integer contarAprovados(Double[] notas){
        Integer aprovados = 0;
        for (int i = 0; i < notas.length; i++) {
            if(notas[i] >= 6.0){
                aprovados++;
            }
        }

        return aprovados;
    }

    Boolean validarQuantidadeNotas(Double[] notas){
        if(quantidadeAlunosMatriculados == notas.length){
            return true;
        } else{
            return false;
        }
    }

    Double encontrarNotaMaisProximaDaMedia(Double[] notas) {
        Double media = calcularMediaTurma(notas);
        Double notaMaisProxima = notas[0];
        Double menorDiferenca = notas[0] - media;
        if (menorDiferenca < 0) {
            menorDiferenca = -menorDiferenca;
        }

        for (int i = 1; i < notas.length; i++) {
            Double diferenca = notas[i] - media;
            if (diferenca < 0) {
                diferenca = -diferenca;
            }

            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                notaMaisProxima = notas[i];
            }
        }

        return notaMaisProxima;
    }

}
