package school.sptech.ex01;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
   private String cliente;
   private List<Produto> produtos;

    public Carrinho(String cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public Integer getQuantidade(){
        return this.produtos.size();
    }

    public void adicionar(Produto p){
        if(p == null){
            System.out.println("produto inválido");
        }
        else {
            this.produtos.add(p);
        }
    }

    public Boolean existsPorNome(String nome){
        for (Produto produto : produtos) {
            if(produto.getNome().toLowerCase().equals(nome.toLowerCase()) ){
                return true;
            }
        }
        return false;
    }

    public Integer getQuantidadePorCategoria(String nome){
        Integer quantidade = 0;
        for (Produto produto : produtos) {
            if(produto.getCategoria() == nome){
                quantidade++;
            }
        }
        return quantidade;
    }

    public void limpar(){
        List<Produto> listaLimpa = new ArrayList<>();
        this.produtos = listaLimpa;
    }

    public void removerPorNome(String nome){
        for (Produto produto : produtos) {
            if(produto.getNome().toLowerCase().contains(nome.toLowerCase())){
                produtos.remove(produto);
                return;
            }
        }
    }

    public Produto getPorNome(String nome){
        for (Produto produto : produtos) {
            if(produto.getNome().toLowerCase().contains(nome.toLowerCase())){
                return produto;
            }
        }
        return null;
    }

    public Double getValorTotal(){
        Double soma = 0.0;
        for (Produto produto : produtos) {
            soma = soma + produto.getPreco();
        }
        return soma;
    }


}
