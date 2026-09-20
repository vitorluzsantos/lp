package school.sptech;

public class PontoDeRecarga {
    private Integer qtdConsultasRealizadas;
    private Integer qtdRecargasRealizadas;

    public PontoDeRecarga(){

    }

    public Integer getQtdConsultasRealizadas(){
        return this.qtdConsultasRealizadas;
    }

    public Integer getQtdRecargasRealizadas(){
        return this.qtdRecargasRealizadas;
    }

    public Double consultarSaldo(BilheteUnico bilhete){
        if(bilhete.getBloqueado()){
            System.out.println("bilhete único bloqueado");
            return 0.0;
        }
        else{
            this.qtdConsultasRealizadas++;
            return bilhete.getSaldo();
        }
    }

    public void recarregar(BilheteUnico bilhete, Double valor){
        if(valor < 5.00){
            System.out.println("Valor mínimo de recarga não atingido");
        } else if(bilhete.getBloqueado()){
            System.out.println("bilhete único bloqueado");
        } else{
            bilhete.setSaldo(bilhete.getSaldo() + valor);
            this.qtdRecargasRealizadas++;
        }
    }

    public void bloquear(BilheteUnico bilhete){
        bilhete.setBloqueado(true);
    }

}
