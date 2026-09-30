package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContaCorrente {
    private String titular;
    private String agencia;
    private String numero;
    private List<Operacao> operacoes;

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void adicionarOperacao(String categoria, String descricao, Double valor){
        if(categoria == null || categoria.isBlank() || descricao == null ||descricao.isBlank() || valor == null || valor == 0){
            return;
        }
        else {
            Operacao operacao = new Operacao(categoria, descricao, valor);
            this.operacoes.add(operacao);
        }
    }

    public Double obterSaldo(){
        if(this.operacoes == null){
            return 0.0;
        }
        else{
            Double soma = 0.0;
            for (Operacao operacao : operacoes) {
                soma = soma + operacao.getValor();
            }
            return soma;
        }
    }

    public List<Operacao> buscarOperacoesPorCategoria(String categoria){
        List<Operacao> listaOperacoes = new ArrayList<>();
        for (Operacao operacao : operacoes) {
            if(operacao.getCategoria().equalsIgnoreCase(categoria)){
                listaOperacoes.add(operacao);
            }
        }
        return listaOperacoes;
    }

    public List<Operacao> buscarOperacoesPorValor(Double valor){
        List<Operacao> listaOperacoes = new ArrayList<>();
        for (Operacao operacao : operacoes) {
            if(Objects.equals(operacao.getValor(), valor)){
                listaOperacoes.add(operacao);
            }
        }
        return listaOperacoes;
    }

    public List<Operacao> buscarOperacoesSaida(){
        List<Operacao> listaOperacoes = new ArrayList<>();
        for (Operacao operacao : operacoes) {
            if(operacao.getValor() < 0){
                listaOperacoes.add(operacao);
            }
        }
        return listaOperacoes;
    }

    public List<Operacao> buscarOperacoesPorDescricao(String descricao){
        List<Operacao> listaOperacoes = new ArrayList<>();
        if(descricao != null){
            for (Operacao operacao : operacoes) {
                if(operacao.getDescricao().toLowerCase().contains(descricao.toLowerCase())){
                    listaOperacoes.add(operacao);
                }
            }
        }
        return listaOperacoes;
    }

    public Double buscarMenorValor(){
        Double menorValor = 0.0;
        if(operacoes == null || operacoes.isEmpty()){
            return menorValor;
        }
        else{
            menorValor = operacoes.getFirst().getValor();
            for (Operacao operacao : operacoes) {
                if(menorValor > operacao.getValor()){
                    menorValor = operacao.getValor();
                }
            }
            return menorValor;
        }
    }

    public Double obterSaldoPorCategoria(String categoria){
        Double saldo = 0.0;
        if(categoria == null || categoria.isBlank()){
            return saldo;
        }
        for (Operacao operacao : operacoes) {
            if(operacao.getCategoria().equalsIgnoreCase(categoria)){
                saldo = saldo + operacao.getValor();
            }
        }
        return saldo;
    }

    public String buscarCategoriaComMaiorGasto(){
        String categoria = "";
        if(operacoes.isEmpty()){
            return null;
        }
        Double maiorGasto = 0.0;
        for (int i = 0; i < operacoes.size(); i++) {
            maiorGasto = 0.0;
            for (int j = 0; j < operacoes.size(); j++) {
                if(operacoes.get(i).getCategoria().equalsIgnoreCase(operacoes.get(j).getCategoria()) && operacoes.get(j).getValor() < 0.0){
                    maiorGasto = operacoes.get(j).getValor();
                    categoria = operacoes.get(i).getCategoria();
                }
            }
        }
        if(maiorGasto >= 0.0){
            return null;
        }
        if(categoria.isBlank()){
            return null;
        }
        return categoria;
    }

    public List<Operacao> buscarOperacoesDuplicadas(){
        List<Operacao> listaOperacao = new ArrayList<>();
        for (int i = 0; i < operacoes.size(); i++) {
            for (int j = 0; j < operacoes.size(); j++) {
                if(i != j ){
                    if(operacoes.get(i).getCategoria().equalsIgnoreCase(operacoes.get(j).getCategoria()) &&
                            operacoes.get(i).getDescricao().equalsIgnoreCase(operacoes.get(j).getDescricao())){
                        listaOperacao.add(operacoes.get(i));
                    }
                }
            }
        }
        return listaOperacao;
    }
}
