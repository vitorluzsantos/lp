package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorMobile extends Desenvolvedor {

    private String plataforma;
    private String linguagem;
    private Integer horasPrototipacao;

    public DesenvolvedorMobile(String nome, Integer qtdHoras, Double valorHora) {
        super(nome, qtdHoras, valorHora);
    }

    public Double calcularSalario(){
        return super.calcularSalario() + (this.horasPrototipacao * 200.0);
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public Integer getHorasPrototipacao() {
        return horasPrototipacao;
    }

    public void setHorasPrototipacao(Integer horasPrototipacao) {
        this.horasPrototipacao = horasPrototipacao;
    }

    @Override
    public String toString() {
        return "DesenvolvedorMobile{" +
                "plataforma='" + plataforma + '\'' +
                ", linguagem='" + linguagem + '\'' +
                ", horasPrototipacao='" + horasPrototipacao + '\'' +
                "} " + super.toString();
    }
}
