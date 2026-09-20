package school.sptech;

public class BilheteUnico {
    private String titular;
    private Integer ano;
    private Boolean estudante;
    private Double saldo;
    private Boolean bloqueado;

    public BilheteUnico(){

    }

    public void setTitular(String valor){
        this.titular = valor;
    }

    public String getTitular(){
        return this.titular;
    }

    public void setEstudante(Boolean valor){
        this.estudante = valor;
    }

    public Boolean getEstudante(){
        return this.estudante;
    }

    public void setAno(Integer valor){
        this.ano = valor;
    }

    public Integer getAno(){
        return this.ano;
    }

    public void setSaldo(Double valor){
        this.saldo = valor;
    }

    public Double getSaldo(){
        return this.saldo;
    }

    public void setBloqueado(Boolean valor){
        this.bloqueado = valor;
    }

    public Boolean getBloqueado(){
        return this.bloqueado;
    }
}
