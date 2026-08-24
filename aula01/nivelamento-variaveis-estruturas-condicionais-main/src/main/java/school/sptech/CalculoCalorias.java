package school.sptech;

public class CalculoCalorias {
    public static void main(String[] args) {
        Integer aquecimento = 1;
        Integer aerobicos = 1;
        Integer musculacao = 1;

        Integer totalCalorias = (aquecimento * 12) + (aerobicos * 20) + (musculacao * 25);
        Integer totalMinutos = aquecimento + aerobicos + musculacao;

        String print = String.format("Ola, Jorge. Você fez um total de %d minutos de exercicios e perdeu cerca de %d calorias", totalMinutos, totalCalorias);
        System.out.println(print);

    }
}
