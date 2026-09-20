package school.sptech;

public class Onibus {
    private Integer qtdPassageiros;
    private Double valorPassagem;

    public Onibus(){

    }

    public Integer getQtdPassageiros(){
        return this.qtdPassageiros;
    }

    public Double getValorPassagem(){
        return this.valorPassagem;
    }

    public void cobrarPassagem(BilheteUnico bilhete){
        if(bilhete.getBloqueado()){
            System.out.println("bilhete único bloqueado");
        }else if(bilhete.getSaldo() < this.getValorPassagem()){
            System.out.println("Não há saldo suficiente para realizar a operação");
        } else{
            if(bilhete.getEstudante()){
                bilhete.setSaldo(bilhete.getSaldo() - this.valorPassagem / 2.0);
            }
            else{
                bilhete.setSaldo(bilhete.getSaldo() - this.valorPassagem);
            }
            this.qtdPassageiros++;
        }

    }

    public void cobrarPassagem(Double dinheiro){
        if(dinheiro < this.valorPassagem){
            System.out.println("Dinheiro insuficiente para realizar operação");
        }
        else{
            this.qtdPassageiros++;
        }
    }
}
