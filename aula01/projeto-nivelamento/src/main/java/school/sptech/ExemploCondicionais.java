package school.sptech;

public class ExemploCondicionais {
    public static void main(String[] args) {
       int idade = 18;
       // if, else, else-if
       if(idade >= 18){
           System.out.println("Você é maior de idade, pode dirigir e votar");
       } else if(idade >= 16){
           System.out.println("Você é menor de idade, mas pode votar ");
       } else {
           System.out.println("Você é menor de idade, não pode votar e nem dirigir");
       }

       String texto = idade >= 18 ? "Maior de idade" : "Menor de idade";
       System.out.println(texto);

        Integer num1 = 1000;
        Integer num2 = 1000;

        // o java quando compara valores na classe wrapper ele olha para o endereco de memoria e não no valor alocado
        // ate o 127 o java aloca os dois valores iguais no mesmo espaço de memoria

        if(num1.equals(num2)){
            System.out.println("são iguais");
        }
        else{
            System.out.println("são diferentes");
        }

        String nome = "Lucas";
        String nome2 = "lucas";

        if(nome.equalsIgnoreCase(nome2)){
            System.out.println("são iguais");
        }
        else{
            System.out.println("são diferentes");
        }
    }
}
