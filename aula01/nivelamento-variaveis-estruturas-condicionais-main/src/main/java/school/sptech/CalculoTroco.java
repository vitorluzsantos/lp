package school.sptech;

public class CalculoTroco {
    public static void main(String[] args) {
        Double valorUnitario = 10.0;
        Integer qtdVendida = 2;
        Double valorPago = 10.0;
        Double troco = valorPago - (valorUnitario * qtdVendida);

        String print;

        if(troco > 0){
            print = String.format("Seu troco será de R$%.2f", troco);
        }
        else if(troco == 0){
            print = "Deu certinho não tem troco";
        }
        else {
            print = String.format("Você esta devendo R$%.2f", (troco * -1));
        }

        System.out.println(print);


    }
}
