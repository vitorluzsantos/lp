package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Votacao {
    public static void main(String[] args) {
        Integer votoMussarela = 0;
        Integer votoCalabresa = 0;
        Integer votoQuatroQueijos = 0;

        Integer numeroAleatorio;

        for (int i = 0; i < 10; i++) {
            numeroAleatorio = ThreadLocalRandom.current().nextInt(1, 4);
            if(numeroAleatorio == 1){
                votoMussarela++;
            }
            else if(numeroAleatorio == 2){
                votoCalabresa++;
            }
            else if(numeroAleatorio == 3){
                votoQuatroQueijos++;
            }
        }

        String saborFavorito = (votoMussarela > votoCalabresa) ? (votoMussarela > votoQuatroQueijos ? "mussarela":"quatro queijos") : (votoCalabresa > votoQuatroQueijos ? "calabresa" : "quatro queijos");

        System.out.println("Sabor mussarela teve " + votoMussarela + " votos");
        System.out.println("Sabor calabresa teve " + votoCalabresa + " votos");
        System.out.println("Sabor quatro queijos teve " + votoQuatroQueijos + " votos");

        System.out.println("O sabor favorito foi " + saborFavorito);
    }
}
