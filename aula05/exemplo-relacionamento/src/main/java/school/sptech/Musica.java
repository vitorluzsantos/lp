package school.sptech;

public class Musica {
    private String nome;
    private String album;
    private String artista;
    private Integer duracaoMin;
    private Integer anoLancamento;

    public Musica(String nome, String album, String artista, Integer duracaoMin, Integer anoLancamento) {
        this.nome = nome;
        this.album = album;
        this.artista = artista;
        this.duracaoMin = duracaoMin;
        this.anoLancamento = anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Integer getDuracaoMin() {
        return duracaoMin;
    }

    public void setDuracaoMin(Integer duracaoMin) {
        this.duracaoMin = duracaoMin;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "nome='" + nome + '\'' +
                ", album='" + album + '\'' +
                ", artista='" + artista + '\'' +
                ", duracaoMin=" + duracaoMin +
                ", anoLancamento=" + anoLancamento +
                '}';
    }
}
