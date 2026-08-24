package school.sptech;

public class ExercicioVetores {

    Integer somar(Integer[] vetor){
        Integer soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma = soma + vetor[i];
        }
        return soma;
    }

    Double calcularMedia(Double[] notas){
        Double soma = 0.0;
        for (int i = 0; i < notas.length; i++) {
            soma = soma + notas[i];
        }
        Double media = soma / notas.length;
        return media;
    }

    Integer buscarMaiorNumero(Integer[] vetor){
        Integer maior = vetor[0];
        for (int i = 0; i < vetor.length; i++) {
            maior = (vetor[i] > maior) ? vetor[i] : maior;
        }
        return maior;
    }

    Integer calcularDecimal(Integer[] binario){
        Integer resultado = 0;
        Integer[] novoVetor = new Integer[binario.length];
        int j = 0;
        for (int i = binario.length - 1; i >= 0; i--) {
            novoVetor[j] = binario[i];
            j++;
        }
        for (int i = 0; i < novoVetor.length; i++) {
            if(novoVetor[i] == 1){
                resultado += ((int) Math.pow(2, i));
            }
        }
        return resultado;
    }

    Character[] inverter(Character[] vetor){
        Character[] novoVetor = new Character[vetor.length];
        int j = 0;
        for (int i = vetor.length - 1; i >= 0; i--) {
            novoVetor[j] = vetor[i];
            j++;
        }
        return novoVetor;
    }

    Integer[] mesclar(Integer[] vetor1, Integer[] vetor2) {
        Integer[] resultado = new Integer[vetor1.length + vetor2.length];
        int i = 0, j = 0, k = 0;
        while (i < vetor1.length && j < vetor2.length) {
            if (vetor1[i] <= vetor2[j]) {
                resultado[k] = vetor1[i];
                i++;
            } else {
                resultado[k] = vetor2[j];
                j++;
            }
            k++;
        }
        while (i < vetor1.length) {
            resultado[k] = vetor1[i];
            i++;
            k++;
        }
        while (j < vetor2.length) {
            resultado[k] = vetor2[j];
            j++;
            k++;
        }
        return resultado;
    }

    Integer[] somarDois(Integer[] vetor, Integer alvo){
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 1; j < vetor.length; j++) {
                if(vetor[i] + vetor[j] == alvo){
                    return new Integer[]{i, j};
                }
            }
        }
        return new Integer[]{};
    }
}