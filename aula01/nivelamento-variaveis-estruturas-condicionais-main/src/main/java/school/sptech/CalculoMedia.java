package school.sptech;

public class CalculoMedia {
    public static void main(String[] args) {
        String nome = "vitor";
        Double nota1 = 7.5;
        Double nota2 = 8.0;

        Double media = (nota1 + nota2)/2;
        String print = String.format("Olá, %s. Sua média foi de %.1f", nome, media);

        System.out.println(print);
    }

}
