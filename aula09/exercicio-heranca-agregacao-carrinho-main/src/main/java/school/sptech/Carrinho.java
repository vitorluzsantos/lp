package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private Integer id;
    private ArrayList<Produto> produtos;

    public void adicionarProduto(Produto produto){
        if(produto.preco == null || produto.preco <= 0 || produto.nome == null ||
                produto.nome.isBlank() || produto.peso == null || produto.peso <= 0){
            return;
        }
        else{
            produtos.add(produto);
        }
    }

    public void removerProduto(String nome){
        for (int i = produtos.size() - 1; i >= 0; i--) {
            if(produtos.get(i).nome.equalsIgnoreCase(nome)){
                produtos.remove(i);
            }
        }
    }

    public Produto buscarProdutoPorNome(String nome){
        for (Produto produto : produtos) {
            if(produto.getNome().equalsIgnoreCase(nome)){
                return produto;
            }
        }
        return null;
    }

    public Double calcularValorTotal(){
        if(produtos.isEmpty()){
            return 0.0;
        }
        else{
            Double soma = 0.0;
            for (Produto produto : produtos) {
                soma = soma + produto.calcularPrecoFinal();
            }
            return  soma;
        }
    }

    public Double calcularTotalFrete(){
        if(produtos.isEmpty()){
            return 0.0;
        }
        else{
            Double soma = 0.0;
            for (Produto produto : produtos) {
                soma = soma + produto.calcularFrete();
            }
            return  soma;
        }
    }

    public List<Celular> buscarCelularesPorMarca(String marca){
        List<Celular> listaCelulares = new ArrayList<>();
        for (Produto produto : produtos) {
            if(produto instanceof Celular celular){
                if(celular.getMarca().equalsIgnoreCase(marca)){
                    listaCelulares.add(celular);
                }
            }
        }
        return listaCelulares;
    }

    public List<Celular> buscarCelularesForaDaGarantia(Integer mesesDeUso){
        List<Celular> listaCelulares = new ArrayList<>();
        for (Produto produto : produtos) {
            if(produto instanceof Celular celular){
                if(celular.getGarantiaMeses() < mesesDeUso){
                    listaCelulares.add(celular);
                }
            }
        }
        return listaCelulares;
    }

    public Produto buscarProdutoMaisBarato(){
        if(produtos.isEmpty()){
            return null;
        }
        else{
            Produto produtoMaisBarato = produtos.getFirst();
            for (int i = 1; i < produtos.size(); i++) {
                if(produtos.get(i).calcularPrecoFinal() < produtoMaisBarato.calcularPrecoFinal()){
                    produtoMaisBarato = produtos.get(i);
                }
            }
            return produtoMaisBarato;
        }
    }

    public Produto buscarProdutoMaisCaro(){
        if(produtos.isEmpty()){
            return null;
        }
        else{
            Produto produtoMaisCaro = produtos.getFirst();
            for (int i = 1; i < produtos.size(); i++) {
                if(produtos.get(i).calcularPrecoFinal() > produtoMaisCaro.calcularPrecoFinal()){
                    produtoMaisCaro = produtos.get(i);
                }
            }
            return produtoMaisCaro;
        }
    }

    public String buscarTipoProdutoMaisPresente(){
        Integer qtdRoupa = 0;
        Integer qtdCelular = 0;
        Integer qtdNormal = 0;

        if(this.produtos.isEmpty()){
            return null;
        }
        else{
            for (Produto produto : produtos) {
                if(produto instanceof Celular celular){
                    qtdCelular++;
                }
                else if(produto instanceof Roupa roupa){
                    qtdRoupa++;
                }
                else{
                    qtdNormal++;
                }
            }
            Integer maior = qtdCelular;
            if(qtdNormal > maior){
                maior = qtdNormal;
            }
            if(qtdRoupa > maior){
                maior = qtdRoupa;
            }
            for (Produto produto : produtos) {
                if(produto instanceof Celular && qtdCelular == maior){
                    return "celular";
                }
                else if(produto instanceof Roupa && qtdRoupa == maior){
                    return "roupa";
                }
                else if(!(produto instanceof Celular) && !(produto instanceof Roupa) && qtdNormal == maior){
                    return "normal";
                }
            }
        }
        return null;
    }

    public List<Produto> buscarTopCincoProdutosMaisBaratos(){
        if(this.produtos.isEmpty()){
            return null;
        }

        List<Produto> restantes = new ArrayList<>(this.produtos);
        List<Produto> topCinco = new ArrayList<>();

        while(topCinco.size() < 5 && !restantes.isEmpty()){
            int indiceMaisBarato = 0;

            for (int i = 1; i < restantes.size(); i++) {
                if(restantes.get(i).calcularPrecoFinal() < restantes.get(indiceMaisBarato).calcularPrecoFinal()){
                    indiceMaisBarato = i;
                }
            }

            topCinco.add(restantes.remove(indiceMaisBarato));
        }

        return topCinco;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "id=" + id +
                ", produtos=" + produtos +
                '}';
    }
}
