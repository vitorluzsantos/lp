package school.sptech.ex1;

public class Bolo {
    String sabor;
    Double valor;
    Integer quantidadeVendida;
    Integer quantidadeEmEstoque;

    void venderBolo(Integer quantidade){
        if(quantidade > 0){
            if(quantidade <= quantidadeEmEstoque){
                quantidadeVendida += quantidade;
                quantidadeEmEstoque -= quantidade;
            }
        }
    }

    void aumentarEstoque(Integer quantidade){
        if(quantidade > 0){
            quantidadeEmEstoque += quantidade;
        }
    }

    Integer quantidadeDisponivel(){
        return quantidadeEmEstoque;
    }

    Double totalVendido(){
        return quantidadeVendida * valor;
    }

}
