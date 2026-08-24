package school.sptech;

import java.util.Scanner;

public class CalculoRenda {
    public static void main(String[] args) {
        Integer qtdBebes = 2;
        Integer qtdCriancas = 3;
        Integer qtdAdolescentes = 4;

        Integer totalFilhos = qtdBebes + qtdCriancas + qtdAdolescentes;
        Double bolsa = (qtdBebes * 25.12) + (qtdCriancas * 15.88) + (qtdAdolescentes * 12.44);

        System.out.println("Você tem um total de " + totalFilhos + " filhos e vai receber R$" + bolsa + " de bolsa");
    }
}
