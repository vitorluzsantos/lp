package school.sptech;

public class Potencia {
    public static void main(String[] args) {
        System.out.println(Math.pow(2,1));

        Integer B = 2;
        Integer E = 5;
//        System.out.println(Math.pow(B, E));
        Integer resultado = 1;

        for (int i = 0; i < E; i++) {
            resultado = resultado * B;
        }
        System.out.println(resultado);
    }
}
