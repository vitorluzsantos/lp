package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Acumulador {
    public static void main(String[] args) {
        Integer numeroAleatorio;
        Integer soma = 0;

        do{
            numeroAleatorio = ThreadLocalRandom.current().nextInt(0, 11);
            soma = soma + numeroAleatorio;
        }
        while(numeroAleatorio != 0);

        System.out.println("A soma dos números é " + soma);
    }
}
