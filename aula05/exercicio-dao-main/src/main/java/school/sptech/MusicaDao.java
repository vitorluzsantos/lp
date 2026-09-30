package school.sptech;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Locale;

public class MusicaDao {

    private final JdbcTemplate jdbcTemplate;

    public MusicaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Escreva os métodos abaixo */

    public List<Musica> findAll(){
        List<Musica> lista = jdbcTemplate.query("SELECT * FROM Musica;",
                new BeanPropertyRowMapper<>(Musica.class));
        return lista;
    }

    public Musica findById(Integer id){
        if(id < 0){
            return null;
        }
        List<Musica> listaMusicas = findAll();
        if(id > listaMusicas.size()){
            return null;
        }
        else{
            Musica musica = jdbcTemplate.queryForObject("SELECT * FROM Musica WHERE id = ?",
                    new BeanPropertyRowMapper<>(Musica.class), id);
            return musica;
        }
    }

    public List<Musica> findByNomeLike(String nome){
        List<Musica> lista = jdbcTemplate.query("SELECT * FROM Musica WHERE LOWER(nome) LIKE ?",
                new BeanPropertyRowMapper<>(Musica.class),"%" + nome.toLowerCase() + "%");
        return lista;
    }

    public List<Musica> findByArtista(String artista){
        List<Musica> lista = jdbcTemplate.query("SELECT * FROM Musica WHERE artista = ?",
                new BeanPropertyRowMapper<>(Musica.class), artista);
        return lista;
    }

    public List<Musica> findByAlbum(String album){
        List<Musica> lista = jdbcTemplate.query("SELECT * FROM Musica WHERE album = ?",
                new BeanPropertyRowMapper<>(Musica.class), album);
        return lista;
    }

    public List<Musica> findByDuracaoGreaterThan(Integer duracao){
        List<Musica> lista = jdbcTemplate.query("SELECT * FROM Musica WHERE duracao > ?",
                new BeanPropertyRowMapper<>(Musica.class), duracao);
        return lista;
    }

    public List<Musica> findByAlbumAndNomeLike(String album, String nome){
        List<Musica> lista = jdbcTemplate.query("SELECT * FROM Musica WHERE album = ? AND LOWER(nome) LIKE ?",
                new BeanPropertyRowMapper<>(Musica.class), album, "%" + nome.toLowerCase() + "%");
        return lista;
    }

    public void save(Musica musica){
        List<Musica> teste;
        if(musica.getId() == null){
            jdbcTemplate.update("INSERT INTO Musica(nome, artista, album, duracao) VALUES (?, ?, ?, ?)",
                    musica.getNome(), musica.getArtista(), musica.getAlbum(), musica.getDuracao());
        }
        else{
            jdbcTemplate.update("UPDATE Musica SET nome = ?, artista = ?, album = ?, duracao = ?",
                    musica.getNome(), musica.getArtista(), musica.getAlbum(), musica.getDuracao() );
        }
    }

    public void deleteById(Integer id){
        jdbcTemplate.update("DELETE FROM Musica WHERE id = ?", id);
    }

}
