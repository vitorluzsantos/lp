package school.sptech;

import org.w3c.dom.ls.LSOutput;

public class Main {

    // oq é um metodo estatico ?
    // é um metodo que pode ser executado sem ser instanciado
    public static void main(String[] args) {
        // mensagem();
        // System.out.println(mensagem2());
        // System.out.println(calcular());
        // System.out.println(calcularMedia(10,10,10));

        Calculadora calculadora = new Calculadora();
        int soma = calculadora.somar(10, 20);
        int subtracao = calculadora.subtrair(50, 20);

        System.out.println(soma);
        System.out.println(subtracao);
        System.out.println(calculadora.dividir());
        System.out.println(calculadora.dividir(10,7,9));

        double resultado = calculadora
                .multiplicar(calculadora.somar(9, 4),calculadora.multiplicar(4,9));


    }

    static void mensagem(){
        // métodos void não retornam nada
        System.out.println("Bom dia!");
    }

    static String mensagem2(){
        return "Aula de Java";
    }

    static Double calcular(){
        return 10.2 + 10.4;
    }

    static Double calcularMedia(double n1, double n2, double n3){
        return (n1 + n2 + n3)/3;
    }
}
