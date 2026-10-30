package school.sptech;

// só pode dar um extend por classe
public class AlunoPos extends Aluno{
    // sub class
    private Double notaTcc;

    public AlunoPos(String nome, String ra){
        super(nome, ra);
        this.notaTcc = 0.0;
    }

    // Sobre escrita <- Override
    @Override // -> Opcional
    public Double calcularNotaFinal(){
        Double notaFinalTcc = this.notaTcc * 0.4;

        // só funciona pq os atributos de aluno tão PROTECTED e alunoPos é uma subclasse
        Double notaFinalAc1 = super.notaAc1 * 0.2;
        Double notaFinalAc2 = super.notaAc2 * 0.2;
        Double notaFinalAc3 = super.notaAc3 * 0.2;
        return notaFinalTcc + notaFinalAc1 + notaFinalAc2 + notaFinalAc3;
    }

    public Double getNotaTcc() {
        return notaTcc;
    }

    public void setNotaTcc(Double notaTcc) {
        this.notaTcc = notaTcc;
    }

    // selecionar o template string contat + super
    @Override
    public String toString() {
        return "AlunoPos{" +
                "notaTcc=" + notaTcc +
                "} " + super.toString();
    }
}
