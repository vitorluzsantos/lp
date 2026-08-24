package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class ExemploNumerosAleatorios {
    public static void main(String[] args) {
        // gera um numero aleatorio transforma pra inteiro e no intervalo entre 0 e 9
        Integer numeroAleatorio = ThreadLocalRandom.current().nextInt(10);
        System.out.println(numeroAleatorio);
    }
}
