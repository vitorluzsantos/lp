package school.sptech.ex3;

public class Funcionario {
    String nome;
    String cargo;
    Double salario;

    void reajustarSalario(Integer reajuste){
        salario += salario * (reajuste / 100.0);
    }

    Double calcularValorHora(){
        return salario / 220.0;
    }

    Double calcularHoraExtra(Integer horasExtras, Integer adicionalNoturno){
        Double valorHora = salario / 220.0;
        Double valorExtra = valorHora + (valorHora * (adicionalNoturno / 100.0));
        return valorExtra * horasExtras;
    }

    Double calcularBonificacaoAnual(){
        Double percentual = 0.0;
        if(salario <= 2500.0){
            percentual = salario * 0.15;
        } else if (salario <= 6000.0) {
            percentual = salario * 0.10;
        } else {
            percentual = salario * 0.05;
        }
        return percentual;
    }

}
