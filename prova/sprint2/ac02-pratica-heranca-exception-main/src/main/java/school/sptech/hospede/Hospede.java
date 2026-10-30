package school.sptech.hospede;

import school.sptech.exceptions.DadoInvalidoException;
import school.sptech.exceptions.LimiteReservasExcedidoException;

import java.util.ArrayList;
import java.util.List;

public class Hospede {
    protected String nome;
    protected String cpf;
    protected Integer limiteReservasAtivas;
    protected List<Reserva> reservas;

    public Hospede(String nome, String cpf) {
        if(nome == null || nome.isBlank() || cpf == null || cpf.isBlank()){
            throw new DadoInvalidoException("Dado nulo ou vazio");
        }
        else{
            this.nome = nome;
            this.cpf = cpf;
            this.limiteReservasAtivas = 3;
            this.reservas = new ArrayList<>();
        }
    }

    public Integer contarReservasAtivas(){
        Integer qtdAtivas = 0;
        for (Reserva reserva : reservas) {
            if(reserva.getAtiva()){
                qtdAtivas++;
            }
        }
        return qtdAtivas;
    }

    public void adicionarReserva(Integer numeroQuarto, Integer qtdDiarias, Double valorDiaria){
        if(contarReservasAtivas() == this.limiteReservasAtivas){
            throw new LimiteReservasExcedidoException("Limite de reservas atingido");
        }
        else{
            Reserva novaReserva = new Reserva(numeroQuarto, qtdDiarias, valorDiaria);
            reservas.add(novaReserva);
        }
    }

    public Double calcularTotalGasto(){
        if(reservas.isEmpty()){
            return 0.0;
        }
        else{
            Double soma = 0.0;
            for (Reserva reserva : reservas) {
                soma = soma + reserva.calcularValor();
            }
            return soma;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getLimiteReservasAtivas() {
        return limiteReservasAtivas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setLimiteReservasAtivas(Integer limiteReservasAtivas) {
        this.limiteReservasAtivas = limiteReservasAtivas;
    }

    @Override
    public String toString() {
        return "Hospede{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", limiteReservasAtivas=" + limiteReservasAtivas +
                ", reservas=" + reservas +
                '}';
    }
}
