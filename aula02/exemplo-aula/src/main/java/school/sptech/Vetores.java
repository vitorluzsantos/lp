package school.sptech;

import java.util.Arrays;

public class Vetores {
    public static void main(String[] args) {
        // Integer[] numeros = new Integer[3]; // tamanho do vetor em java é fixo
        // numeros[0] = 10;
        // numeros[1] = 20;
        // numeros[2] = 30;

        Calculadora calculadora = new Calculadora();
        Integer[] numeros = {10, 20, 30};

        System.out.println(calculadora.somar(numeros));
        // se der o erro out of bound quer dizer que você tava acessando uma posição que não existe do vetor

        System.out.println(Arrays.toString(numeros));

        // numeros.fori
        for (int i = 0; i < numeros.length; i++) {
            Integer numeroDaVez = numeros[i];
//            System.out.println(numeroDaVez);
        }

        // numeros.forr
        for (int i = numeros.length - 1; i >= 0; i--) {
            Integer numeroDavez = numeros[i];
//            System.out.println(numeroDavez);
        }

        // numeros.for
        for(Integer numeroDaVez : numeros){
//            System.out.println(numeroDaVez);
        }
    }
}
