package school.sptech;

public class ExemploLacosRepeticao {
    public static void main(String[] args) {
        //for, while
        for (int i = 0; i < 10; i++) {
            System.out.println("Número dentro do for: " + (i + 1));
        }

        int num = 10;
        while(num < 10){
            System.out.println("Número dentro do while: " + num);
            num ++;
        }

        int numDoWhile = 10;
        do{
            System.out.println("Numero dentro do do-while: " + numDoWhile);
            numDoWhile ++;
        }
        while (numDoWhile < 10);
    }

}
