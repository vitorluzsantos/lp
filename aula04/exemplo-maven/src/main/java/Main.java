import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {

        // !. acessar o site mvnrepository
        // 2. escolher a dependencia, versão e acessar ela
        // 3. copiar o bloco <dependency>
        // 4. acessar o pom.xml
        // 5. criar um bloco chamado dependencys
        // 6. colar o <dependency> dentro dele

        Faker faker = new Faker();
        System.out.println(faker.name().fullName());
    }
}
