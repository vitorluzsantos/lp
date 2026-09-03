package school.sptech;

public class Jogador {

    String nome;
    Double saldo;
    Integer quantidadeFichas;
    Integer quantidadePartidas;
    Integer vitorias;

    Boolean validarJogador(){
        if(nome == null || saldo == null || saldo < 0){
            return false;
        }
        else{
            return true;
        }
    }

    void registrarPartida(Boolean vitoria){
        quantidadePartidas ++;
        if(vitoria){
            vitorias++;
        }
    }

    Boolean consumirFicha(Integer quantidadeFichasParaConsumo){
        if(quantidadeFichasParaConsumo < 0 || quantidadeFichasParaConsumo > quantidadeFichas){
            return false;
        }
        else {
            quantidadeFichas -= quantidadeFichasParaConsumo;
            return true;
        }
    }

    Boolean comprarFichas(Integer quantidadeFichasParaCompra){
        Double preco = 0.0;
        if(quantidadeFichasParaCompra < 0){
            return false;
        } else if(quantidadeFichasParaCompra <= 5){
            preco = quantidadeFichasParaCompra * 5.0;
        } else if (quantidadeFichasParaCompra <= 10) {
            preco = quantidadeFichasParaCompra * 4.0;
        } else{
            preco = quantidadeFichasParaCompra * 3.0;
        }

        if(saldo < preco){
            return false;
        }
        else{
            saldo = saldo - preco;
            quantidadeFichas += quantidadeFichasParaCompra;
            return true;
        }
    }

    Integer encontrarMaiorPontuacao(Integer[] pontuacoes){
        if(pontuacoes.length > 0){
            Integer maiorPontuacao = pontuacoes[0];
            for (int i = 1; i < pontuacoes.length; i++) {
                if(maiorPontuacao < pontuacoes[i]){
                    maiorPontuacao = pontuacoes[i];
                }
            }
            return maiorPontuacao;
        }
        else{
            return null;
        }
    }

    Integer contarPontuacoesAcimaDaMedia(Integer[] pontuacoes){
        if(pontuacoes.length > 0){
            Integer soma = 0;
            for (int i = 0; i < pontuacoes.length; i++) {
                soma = soma + pontuacoes[i];
            }
            Integer media = soma / pontuacoes.length;
            Integer quantidade = 0;
            for (int i = 0; i < pontuacoes.length; i++) {
                if(pontuacoes[i] > media){
                    quantidade++;
                }
            }
            return quantidade;
        }
        else{
            return 0;
        }
    }

    Integer encontrarMaiorSequenciaDeVitorias(Boolean[] resultados){
        Integer maiorSequencia = 0;
        Integer aux = 0;

        for (int i = 0; i < resultados.length; i++) {
            if(resultados[i] == true){
                aux++;
            }
            if(resultados[i] == false){
                aux = 0;
            }
            if(aux > maiorSequencia){
                maiorSequencia = aux;
            }
        }
        return maiorSequencia;
    }
}
