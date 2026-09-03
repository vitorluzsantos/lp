package com.school.sptech;

public class TestarCarro {
    public static void main(String[] args) {


        Carro carro = new Carro();
        carro.ano = 1972;
        carro.marca = "Fiat";
        carro.modelo = "Punto";

        Carro carro2 = new Carro();
        carro2.ano = 2003;
        carro2.marca = "VW";
        carro2.modelo = "Polo";
        carro2.kmRodado = 10000;
        carro2.ligado();

        System.out.println(carro.marca);
        System.out.println(carro2.marca);
        System.out.println(carro2.ligado());

        if(carro2.ligado()){
            System.out.println(carro2.modelo + " esta ligado");
            System.out.println(carro2.kmRodado + "Km rodados");
        }

        Aluno vitor = new Aluno();

    }

    static int informarKM(){
        int km = 15000;
        return km;
    }

}
