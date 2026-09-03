package school.sptech.ex5;

public class Pokemon {
    String nome;
    String tipo;
    Integer vida;
    Integer ataque;
    Integer experiencia;

    void receberAtaque(Integer danoRecebido){
        if(danoRecebido > 0){
            if(vida - danoRecebido < 0){
                vida = 0;
            }else{
                vida = vida - danoRecebido;
            }
        }
    }

    void recuperarVida(Integer quantidadeVida){
        if(quantidadeVida > 0 ){
            if(vida + quantidadeVida > 100){
                vida = 100;
            }
            else{
                vida = vida + quantidadeVida;
            }
        }
    }

    void ganharExperiencia(Integer quantidadeExperiencia){
        if(quantidadeExperiencia > 0){
            experiencia += quantidadeExperiencia;
        }
    }

    Integer calcularNivel(){
        return experiencia / 100;
    }

    Integer calcularPoderDeCombate(){
        return ataque + (10 * calcularNivel()) + vida;
    }

    void batalhar(Integer[] ataques, Integer[] curas){
        for (int i = 0; i < ataques.length; i++) {
            receberAtaque(ataques[i]);

            if(vida > 0){
                recuperarVida(curas[i]);
            }
        }

    }

}
