package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor{
    private String backend;
    private String frontend;
    private String sgbd;
    private Integer horasMentoria;

    public DesenvolvedorWeb(String nome, Integer qtdHoras, Double valorHora, String backend, String frontend, String sgbd, Integer horasMentoria) {
        super(nome, qtdHoras, valorHora);
        this.backend = backend;
        this.frontend = frontend;
        this.sgbd = sgbd;
        this.horasMentoria = horasMentoria;
    }

    public Double calcularSalario(){
        return super.calcularSalario() + (this.horasMentoria * 300.0);
    }

    public Boolean isFullstack(){
        if(this.frontend == null || this.backend == null || this.sgbd == null ||
            this.frontend.isBlank() || this.backend.isBlank() || this.sgbd.isBlank()){
            return false;
        }
        else{
            return true;
        }
    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public Integer getHorasMentoria() {
        return horasMentoria;
    }

    public void setHorasMentoria(Integer horasMentoria) {
        this.horasMentoria = horasMentoria;
    }

    @Override
    public String toString() {
        return "DesenvolvedorWeb{" +
                "backend='" + backend + '\'' +
                ", frontend='" + frontend + '\'' +
                ", sgbd='" + sgbd + '\'' +
                ", horasMentoria=" + horasMentoria +
                "} " + super.toString();
    }
}
