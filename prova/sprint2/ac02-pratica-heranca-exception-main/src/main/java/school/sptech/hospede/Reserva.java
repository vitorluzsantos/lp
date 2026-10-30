package school.sptech.hospede;

import school.sptech.exceptions.DadoInvalidoException;

public class Reserva {
    private Integer numeroQuarto;
    private Integer qtdDiarias;
    private Double valorDiaria;
    private Boolean ativa;

    public Reserva(Integer numeroQuarto, Integer qtdDiarias, Double valorDiaria) {
        if(numeroQuarto == null || numeroQuarto <= 0 || qtdDiarias == null || qtdDiarias <= 0 || valorDiaria == null || valorDiaria <= 0){
            throw new DadoInvalidoException("Dado nulo ou menor igual a zero");
        }
        else{
            this.numeroQuarto = numeroQuarto;
            this.qtdDiarias = qtdDiarias;
            this.valorDiaria = valorDiaria;
            this.ativa = true;
        }
    }

    public Double calcularValor(){
        Double valorReserva = this.valorDiaria * this.qtdDiarias;
        if(qtdDiarias > 5){
            valorReserva = valorReserva - (valorReserva * 0.2);
        }
        if(qtdDiarias <= 10){
            valorReserva = valorReserva + 40;
        }
        return valorReserva;
    }

    public void finalizar(){
        this.ativa = false;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public Integer getQtdDiarias() {
        return qtdDiarias;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "numeroQuarto=" + numeroQuarto +
                ", qtdDiarias=" + qtdDiarias +
                ", valorDiaria=" + valorDiaria +
                ", ativa=" + ativa +
                '}';
    }
}
