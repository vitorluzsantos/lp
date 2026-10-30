package school.sptech;

import javax.print.DocFlavor;

public class Roupa extends Produto{
    private String cor;
    private Double tamanho;
    private String material;

    @Override
    public Double calcularPrecoFinal(){
        if(this.material.equalsIgnoreCase("couro")){
            return super.calcularPrecoFinal() - (super.calcularPrecoFinal() * 0.15);
        }
        return super.calcularPrecoFinal();
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Roupa{" +
                "cor='" + cor + '\'' +
                ", tamanho=" + tamanho +
                ", material='" + material + '\'' +
                "} " + super.toString();
    }
}
