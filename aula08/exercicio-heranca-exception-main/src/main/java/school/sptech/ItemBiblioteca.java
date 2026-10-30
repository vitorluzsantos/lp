package school.sptech;

import school.sptech.exceptions.DadoInvalidoException;
import school.sptech.exceptions.ItemIndisponivelException;

public class ItemBiblioteca {
    private String titulo;
    private Usuario emprestadoPara;

    public ItemBiblioteca(String titulo) {
        if(titulo == null || titulo.isBlank()){
            throw new DadoInvalidoException("titulo é invalido ou é nulo");
        }
        else {
            this.titulo = titulo;
        }
    }

    public void emprestar(Usuario usuario) throws ItemIndisponivelException {
        if(usuario == null){
            throw new DadoInvalidoException("O usuario é nulo");
        }
        if(this.emprestadoPara == null){
            this.emprestadoPara = usuario;
        }
        else{
            throw new ItemIndisponivelException("item ja emprestado para o" + this.emprestadoPara.getNome());
        }
    }

    public void devolver(){
        this.emprestadoPara = null;
    }

    public Integer getPrazoEmprestimoDias(){
        return 7;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getEmprestadoPara() {
        return emprestadoPara;
    }

    public void setEmprestadoPara(Usuario emprestadoPara) {
        this.emprestadoPara = emprestadoPara;
    }

    @Override
    public String toString() {
        return "ItemBiblioteca{" +
                "titulo='" + titulo + '\'' +
                ", emprestadoPara=" + emprestadoPara +
                '}';
    }
}