package school.sptech;

public class Calculadora {

    // por que não precisa do static na class
    // toda vez que voce tiver dentro da classe main tem que ter o static na frente dos metodos
    Integer somar(int n1, int n2){
        return n1 + n2;
    }

    Integer somar(Integer[] nums){
        Integer resultado = 0;
        for (int i = 0; i < nums.length; i++) {
            resultado = resultado + nums[i];
        }
        return resultado;
    }

    int subtrair(int n1, int n2){ return n1 - n2; }

    int multiplicar(int n1, int n2){ return (somar(4,5)*n2)*1;}

    // sobrecarga de metodo

    double dividir(int n1, int n2){ return n1 / n2; }

    double dividir(){ return 0;}

    Double dividir(double n1, double n2, double n3){ return n1 / n2 / n3; }
}
