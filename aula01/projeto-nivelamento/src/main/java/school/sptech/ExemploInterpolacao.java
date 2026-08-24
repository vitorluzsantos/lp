package school.sptech;

public class ExemploInterpolacao {
    public static void main(String[] args) {
        System.out.println("Texto " + 10);

        String nome = "raphael";
        int idade = 10;
        Double altura = 1.80;
        String texto = "Meu nome é %s e minha idade é %d e minha altura é (talvez seja) %.2f".formatted(nome, idade, altura);
        System.out.println(texto);

        String texto2 = String.format("Meu nome é %s e minha idade é %d e minha altura é (talvez seja) %.2f", nome, idade, altura);
        System.out.println("Texto usando .formatted");
        System.out.println(texto);
        System.out.println("Texto usando String.format()");
        System.out.println(texto2);

        System.out.printf("Meu nome é %s, minha idade é %d e minha altura é (talvez seja) %.2f", nome, idade, altura);

        String textao =
                """
                Meu nome é %s
                Minha idade é %d
                Minha altura é %.2f
                #JavaMelhorQueJS
                """.formatted(nome,idade,altura);

        System.out.println(textao);

    }
}
