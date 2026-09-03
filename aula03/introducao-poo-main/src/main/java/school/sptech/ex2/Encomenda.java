package school.sptech.ex2;

public class Encomenda {

    String tamanho;
    String enderecoRemetente;
    String enderecoDestinatario;
    Double distancia;
    Double valorProduto;

    Double calcularFrete(){
        Double frete = 0.0;
        if(tamanho == "P"){
            frete = valorProduto * 0.01;
        }
        if(tamanho == "M"){
            frete = valorProduto * 0.03;
        }
        if(tamanho == "G"){
            frete = valorProduto * 0.05;
        }
        if(distancia <= 50){
            frete += 3.0;
        } else if (distancia <= 200) {
            frete += 5.0;
        }
        else{
            frete += 7.0;
        }
        return frete;
    }

    Double aplicarCupomDeDesconto(Integer porcentagem){
        return valorProduto = valorProduto - (valorProduto * (porcentagem / 100.0));
    }

    Double valorTotalDaEncomenda(){
        return valorProduto + calcularFrete();
    }
}
