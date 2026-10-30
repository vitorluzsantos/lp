package school.sptech;

public class Main {
    public static void main(String[] args) {
        Aluno aluno01 = new Aluno("lucas", "04261100");
        aluno01.setNotaAc1(5.0);
        aluno01.setNotaAc2(7.0);
        aluno01.setNotaAc3(4.0);
        System.out.println(aluno01);
        System.out.println("Nota final do aluno: " + aluno01.calcularNotaFinal());

        AlunoPos alunoPos01 = new AlunoPos("isabela", "0421101");
        alunoPos01.setNotaAc1(8.0);
        alunoPos01.setNotaAc2(9.0);
        alunoPos01.setNotaAc3(10.0);
        alunoPos01.setNotaTcc(7.0);
        System.out.println(alunoPos01);
        System.out.println("Nota final do aluno da pós: " + alunoPos01.calcularNotaFinal());

        Faculdade faculdade = new Faculdade("SPTech");

        faculdade.adicionarAluno(aluno01);
        faculdade.adicionarAluno(alunoPos01);
        // ele sabe automaticamente qual o tipo da classe e adota o metodo
        // sobre escrito automaticamente desde que seja uma herança
        System.out.println("Média das notas finais da faculade: " + faculdade.calcularMediaNotasFaculdade());
    }
}
