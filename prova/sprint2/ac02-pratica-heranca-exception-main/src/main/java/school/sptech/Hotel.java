package school.sptech;

import school.sptech.exceptions.DadoInvalidoException;
import school.sptech.exceptions.HospedeNaoEncontradoException;
import school.sptech.exceptions.QuartoIndisponivelException;
import school.sptech.hospede.Hospede;
import school.sptech.hospede.HospedeVip;
import school.sptech.hospede.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel {
    private String nome;
    private List<Hospede> hospedes;

    public Hotel(String nome){
        if(nome == null || nome.isBlank()){
            throw new DadoInvalidoException("Dado nulo ou vazio");
        }
        else{
            this.nome = nome;
            this.hospedes = new ArrayList<>();
        }
    }

    public Hospede buscarPorCpf(String cpf){
        for (Hospede hospede : hospedes) {
            if(hospede.getCpf().equals(cpf)){
                return hospede;
            }
        }
        throw new HospedeNaoEncontradoException("hospede não encontrado");
    }

    public Double calcularFaturamentoTotal(){
        Double soma = 0.0;
        for (Hospede hospede : hospedes) {
            soma = soma + hospede.calcularTotalGasto();
        }
        return soma;
    }

    public Hospede buscarHospedeQueMaisGastou(){
        if(hospedes.isEmpty()){
            return null;
        }
        Hospede hospedeQueMaisGastou = hospedes.getFirst();
        for (int i = 0; i < hospedes.size(); i++) {
            if(hospedes.get(i).calcularTotalGasto() > hospedeQueMaisGastou.calcularTotalGasto()){
                hospedeQueMaisGastou = hospedes.get(i);
            }
        }
        return hospedeQueMaisGastou;
    }

    public List<HospedeVip> buscarHospedesVip(){
        List<HospedeVip> hospedesVips = new ArrayList<>();
        for (Hospede hospede : hospedes) {
            if(hospede instanceof HospedeVip hospedeVip){
                hospedesVips.add(hospedeVip);
            }
        }
        return hospedesVips;
    }

    public void cadastrarHospede(Hospede hospede){
        try{
           buscarPorCpf(hospede.getCpf());
        }catch(Exception e){
            hospedes.add(hospede);
        }
    }

    public List<Hospede> buscarPorTipo(String tipo){
        List<Hospede> listaHospedesVip = new ArrayList<>();
        List<Hospede> listaHospedesClassicos = new ArrayList<>();
        for (Hospede hospede : hospedes) {
            if(hospede instanceof HospedeVip hospedeVip){
                listaHospedesVip.add(hospedeVip);
            }
            else {
                listaHospedesClassicos.add(hospede);
            }
        }
        if(tipo.equalsIgnoreCase("vip")){
            return listaHospedesVip;
        }
        if(tipo.equalsIgnoreCase("classico")){
            return listaHospedesClassicos;
        }
        return new ArrayList<>();
    }

    public void verificarDisponibilidade (Integer numeroQuarto) throws QuartoIndisponivelException {
        if(numeroQuarto == null || numeroQuarto <= 0){
            throw new DadoInvalidoException("numero quarto invalido");
        }
        for (Hospede hospede : hospedes) {
            List<Reserva> reservas = hospede.getReservas();
            for (Reserva reserva : reservas) {
                if(reserva.getAtiva()){
                    if(reserva.getNumeroQuarto() == numeroQuarto){
                        throw new QuartoIndisponivelException("quarto indisponivel");
                    }
                }
            }
        }
    }

    public void reservar(String cpf, Integer numeroQuarto, Integer qtdDiarias, Double valorDiaria){
        try{
            Hospede hospede = buscarPorCpf(cpf);
            verificarDisponibilidade(numeroQuarto);
            hospede.adicionarReserva(numeroQuarto, qtdDiarias, valorDiaria);
        }
        catch (HospedeNaoEncontradoException e){
            throw new HospedeNaoEncontradoException("hospede não encontrado");
        } catch (QuartoIndisponivelException e) {
            System.out.println("o quarto esta ocupado");
        }
    }

    public void promoverParaVip(String cpf, Double percentualDesconto){
        try{
            Hospede hospede = buscarPorCpf(cpf);
            if(hospede instanceof HospedeVip hospedeVip){
                return;
            }
            if(hospede.getReservas().size() < 3){
                return;
            }
        }
        catch (HospedeNaoEncontradoException e){
            throw new HospedeNaoEncontradoException("hospede não encontrado");
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Hospede> getHospedes() {
        return hospedes;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nome='" + nome + '\'' +
                ", hospedes=" + hospedes +
                '}';
    }
}
