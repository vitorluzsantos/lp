package school.sptech;

import school.sptech.exceptions.DadoInvalidoException;

public class Livro extends ItemBiblioteca{
    private String autor;

    public Livro(String titulo, String autor) {
        super(titulo);
        if(autor == null || autor.isBlank()){
            throw new DadoInvalidoException("autor é invalido ou nulo");
        }
        else{
            this.autor = autor;
        }
    }

    public Integer getPrazoEmprestimoDias(){
        return 14;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                "} " + super.toString();
    }
}