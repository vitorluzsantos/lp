package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private Usuario dono;
    private List<Musica> musicas;

    public Playlist(String nome, Usuario dono) {
        this.nome = nome;
        this.dono = dono;
        this.musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica){
        if(musica == null){
            System.out.println("música inválida");
        }
        else{
            this.musicas.add(musica);
        }
    }

    public void removerMusica(Musica musica){
        if (musica == null){
            System.out.println("música inválida");
        }
        else{
            this.musicas.remove(musica);
        }
    }

    public void removerMusica(Integer indice){
        if (indice == null || indice > this.musicas.size()){
            System.out.println("música inválida");
        }
        else{
            this.musicas.remove(indice);
        }
    }

    public Integer getDuracaoTotal(){
        Integer duracao = 0;
        for(Musica musica : this.musicas){
            duracao = duracao + musica.getDuracaoMin();
        }
        return duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "nome='" + nome + '\'' +
                ", dono=" + dono +
                ", musicas=" + musicas +
                '}';
    }
}
