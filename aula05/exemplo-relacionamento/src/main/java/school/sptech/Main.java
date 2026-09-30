package school.sptech;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(
                "Vitor",
                LocalDate.of(2007,11,07),
                "vitor@email.com",
                "11111111111"
        );

        Musica musica01 = new Musica(
                "Sorry",
                "Sorry",
                "Justin Bieber",
                3,
                2015
        );

        Musica musica02 = new Musica(
                "Young and Beautiful",
                "Simple",
                "Lana Del Rey",
                4,
                2013
        );

        Musica musica03 = new Musica(
                "Numb",
                "Meteora",
                "Linkinpark",
                3,
                2003
        );

        Playlist playlist = new Playlist("As melhores de 1CCOA", usuario);
        playlist.adicionarMusica(musica01);

        playlist.removerMusica(1);
        playlist.removerMusica(musica01);

        System.out.println(playlist);
    }

}
