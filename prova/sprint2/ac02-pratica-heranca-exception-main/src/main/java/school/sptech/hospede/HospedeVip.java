package school.sptech.hospede;

import school.sptech.exceptions.DadoInvalidoException;

public class HospedeVip extends Hospede{
    private Double percentualDesconto;

    public HospedeVip(String nome, String cpf, Double percentualDesconto) {
        super(nome, cpf);
        if(percentualDesconto == null || percentualDesconto < 0 || percentualDesconto > 50){
            throw new DadoInvalidoException("Dado nulo ou menor igual a zero ou desconto maior que 50 porcento");
        }
        else{
            this.percentualDesconto = percentualDesconto;
            super.limiteReservasAtivas = 10;
        }
    }

    @Override
    public Double calcularTotalGasto(){
        Double soma = 0.0;
        for (Reserva reserva : reservas) {
            soma = soma + reserva.calcularValor();
        }
        return soma - (soma * (this.percentualDesconto / 100));
    }

    public Double getPercentualDesconto() {
        return percentualDesconto;
    }

    @Override
    public String toString() {
        return "HospedeVip{" +
                "percentualDesconto=" + percentualDesconto +
                "} " + super.toString();
    }
}
