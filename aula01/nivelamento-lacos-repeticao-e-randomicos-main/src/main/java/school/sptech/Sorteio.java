package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Sorteio {
    public static void main(String[] args) {
        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 101);
        Integer posicao = 0;
        Integer numerosImpares = 0;
        Integer numerosPares = 0;

        for (int i = 0; i < 200; i++) {
            if(i % 2 == 0){
                numerosPares++;
            }
            else{
                numerosImpares++;
            }
            if(i == numeroAleatorio){
                posicao = i;
                break;
            }
        }
        System.out.println("O numero foi sorteado pela primeira vez no " + posicao + " sorteio");
        System.out.println("Foram sorteados " + numerosPares + " numeros pares");
        System.out.println("Foram sorteados " + numerosImpares + " numeros impares");
    }
}
