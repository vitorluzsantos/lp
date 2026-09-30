package ex01;

import java.util.List;

public class Loja {
    private Integer totalPedidosRealizados;
    private Integer totalDescontosAplicados;
    private Integer totalPedidosCancelados;
    private Pedido pedido;

    public Loja() {
        this.totalPedidosRealizados = 0;
        this.totalDescontosAplicados = 0;
        this.totalPedidosCancelados = 0;
    }

    public Integer getTotalPedidosRealizados() {
        return this.totalPedidosRealizados;
    }

    public Integer getTotalDescontosAplicados() {
        return this.totalDescontosAplicados;
    }

    public Integer getTotalPedidosCancelados() {
        return this.totalPedidosCancelados;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void aplicarPromocao(Pedido pedido){
        pedido.setItemPromocional(true);
    }

    public void cancelarPedido(Pedido pedido){
        pedido.setCancelado(true);
        this.totalPedidosCancelados++;
    }

    public Boolean aplicarDesconto(Pedido pedido, Double porcetagem){
        if(!pedido.getCancelado() && pedido.getItemPromocional()){
            pedido.setValorTotalComDesconto(pedido.calcularValorTotal() - (pedido.calcularValorTotal() * (porcetagem/100)));
            this.totalDescontosAplicados++;
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean concluirPedido(Pedido pedido, Double pagamento) {
        if (pagamento != null && pagamento > 0 && pedido.getPendente() && !pedido.getCancelado()) {
            if (pedido.getItemPromocional()) {
                if (pagamento >= pedido.getValorTotalComDesconto()) {
                    pedido.setPendente(false);
                    this.totalPedidosRealizados++;
                    return true;
                } else {
                    return false;
                }
            } else {
                if (pagamento >= pedido.calcularValorTotal()) {
                    pedido.setPendente(false);
                    this.totalPedidosRealizados++;
                    return true;
                } else {
                    return false;
                }
            }
        }
        else {
            return false;
        }
    }

    public Double calcularFaturamentoTotal(List<Pedido> pedidos){
        Double soma = 0.0;
        for (Pedido pedido : pedidos) {
            if(!pedido.getCancelado() && !pedido.getPendente()){
                if(pedido.getItemPromocional()){
                    soma = soma + pedido.getValorTotalComDesconto();
                }
                else{
                    soma = soma + pedido.calcularValorTotal();
                }
            }
        }
        return soma;
    }

    public Double calcularTicketMedio(List<Pedido> pedidos){
        Double soma = 0.0;
        Integer pedidosConcluidos = 0;
        for (Pedido pedido : pedidos) {
            if(!pedido.getCancelado() && !pedido.getPendente()){
                pedidosConcluidos++;
                if(pedido.getItemPromocional()){
                    soma = soma + pedido.getValorTotalComDesconto();
                }
                else{
                    soma = soma + pedido.calcularValorTotal();
                }
            }
        }
        if(pedidosConcluidos > 0){
            return soma / pedidosConcluidos;
        }
        else {
            return 0.0;
        }
    }

    public String buscarProdutoMaisVendido(List<Pedido> pedidos){
        Integer quantidade = 0;
        Integer maiorQuantidade = 0;
        String nomeProduto = "";
        for (int i = 0; i < pedidos.size(); i++) {
            quantidade = 0;
            if(!pedidos.get(i).getCancelado() && !pedidos.get(i).getPendente()){
                for (int j = 0; j < pedidos.size(); j++) {
                    if(!pedidos.get(j).getCancelado() && !pedidos.get(j).getPendente()){
                        if(pedidos.get(i).getProduto() == pedidos.get(j).getProduto()){
                            quantidade++;
                        }
                    }
                }
            }
            if(quantidade > maiorQuantidade){
                nomeProduto = pedidos.get(i).getProduto();
                maiorQuantidade = quantidade;
            }
        }
        if(maiorQuantidade > 0){
            return nomeProduto;
        }
        else{
            return null;
        }
    }
}
