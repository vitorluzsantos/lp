package school.sptech;

import java.util.Locale;

public class ExercicioMetodos {
    Boolean verificarMaioridade(Integer idade){
        if(idade >= 18){
            return true;
        }
        else{
            return false;
        }
    }

    Double calcularMedia(Double valor1, Double valor2, Double valor3){
        return (valor1 + valor2 + valor3)/3;
    }

    Integer maiorNumero(Integer valor1, Integer valor2){
        if(valor1 > valor2){
            return valor1;
        }
        else{
            return valor2;
        }
    }

    Integer maiorNumero(Integer valor1, Integer valor2, Integer valor3){
        if(maiorNumero(valor1,valor2) > valor3){
            return maiorNumero(valor1, valor2);
        }
        else{
            return valor3;
        }
    }

    Integer calcularFatorial(Integer valor){
        Integer soma = valor;

        if(valor != 0){
            while(valor > 1){
                soma = soma * (valor - 1);
                valor--;
            }
            return soma;
        }
        else{
            return 1;
        }
    }

    Boolean verificarPrimo(Integer valor){
        if(valor <= 1){
            return false;
        }
        if(valor == 2){
            return true;
        }
        if((valor > 2 ) && (valor % 2 == 0)){
            return false;
        }
        for (int i = 3; i < valor; i = i + 2) {
            if(valor % i == 0) {
                return false;
            }
        }
        return true;
    }

    Integer calcularPotencia(Integer base, Integer expoente){
        Integer soma = base;
        if(expoente == 0){
            return 1;
        }
        while(expoente > 1){
            soma = soma * base;
            expoente--;
        }
        return soma;
    }

    Integer calcularTrocoEmBalas(Double valorCompra, Double valorRecebido){
        Integer quantidade = 0;
        if(valorRecebido >= valorCompra){
            Double troco = valorRecebido - valorCompra;
            while(troco >= 0.25){
                troco = troco - 0.25;
                quantidade++;
            }
            return quantidade;
        }
        else{
            return null;
        }
    }

    Boolean verificarPalindromo(String palavra) {
        if (palavra == null) {
            return false;
        }
        String textoLimpo = palavra.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int inicio = 0;
        int fim = textoLimpo.length() - 1;
        while (inicio < fim) {
            if (textoLimpo.charAt(inicio) != textoLimpo.charAt(fim)) {
                return false; // Encontrou diferença, não é palíndromo
            }
            inicio++;
            fim--;
        }
        return true;
    }
}

