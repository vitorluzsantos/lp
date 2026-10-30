package school.sptech;

import school.sptech.exceptions.DadoInvalidoException;

public class Dvd extends ItemBiblioteca{
    private Integer duracao;

    public Dvd(String titulo, Integer duracao) {
        super(titulo);
        if(duracao == null || duracao <= 0){
            throw new DadoInvalidoException("Duração nula ou menor igual a zero");
        }
        else{
            this.duracao = duracao;
        }
    }

    public Integer getPrazoEmprestimoDias(){
        return 3;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Dvd{" +
                "duracao=" + duracao +
                "} " + super.toString();
    }
}