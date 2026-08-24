package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Loteria {
    public static void main(String[] args) {
        Integer numeroEscolhido = 7;
        Integer numeroAleatorio;
        Integer contador = 0;
        do{
            numeroAleatorio = ThreadLocalRandom.current().nextInt(0,11);
            contador ++;

        }
        while(numeroAleatorio != numeroEscolhido);

        String resposta;
        if(contador <= 3){
            resposta = "Você é muito sortudo";
        }
        else if(contador <= 10){
            resposta = "Você é sortudo";
        }
        else{
            resposta = "É melhor você parar de apostar e ir trabalhar";
        }

        System.out.println(resposta);

    }
}
