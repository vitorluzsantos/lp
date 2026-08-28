package com.school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // na prova não podem usar metodos tipo sort, reversed

        // Vetor estático
        Integer[] nums = new Integer[0];

        // Vetor dinâmico
        List<String> nomes = new ArrayList<>();
        nomes.add("jablobe");
        nomes.add("vitao");
        nomes.add("caiao");
        nomes.add("marinao");
        nomes.add("caiao");
        System.out.println(nomes);

        // nomes[1] <- não funciona com lista tem que usar o metodo get
        System.out.println("O primeiro elemento da lista: " + nomes.get(0));
        System.out.println("O segundo elemento da lista: " + nomes.get(1));

        // lista não tem .length() tem .size()
        System.out.println("O tamanho da lista: " + nomes.size());
        System.out.println("O ultimo elemento da lista: " + nomes.get(nomes.size() - 1));

        for (int i = 0; i < nomes.size(); i++) {
            nomes.get(i);
        }

        // remover elemento da lista
        nomes.remove(0);
        nomes.remove("caiao");
        System.out.println(nomes);

        // listas não aceitam tipos primitivos
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        System.out.println(numeros);
        Integer valor = 2;
        numeros.remove(valor);
        System.out.println(numeros);

        // como atualizar um elemento da lista
        // .set() recebe o indice , item
        nomes.set(2, "luisao");
        System.out.println(nomes);

        List<Integer> numerosMutaveis = new ArrayList<>();
        numerosMutaveis.add(10);
        System.out.println(numerosMutaveis);
        List<Integer> numerosImutaveis = List.of(10, 20, 30);
        numerosImutaveis.add(40);
        System.out.println(numerosImutaveis);
    }
}
