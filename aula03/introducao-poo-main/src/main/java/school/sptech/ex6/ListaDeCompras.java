package school.sptech.ex6;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {
    String nomeLista;
    Integer capacidadeMaxima;
    List<String> itens;

    void adicionarItem(String nomeItem){
        Boolean duplicado = false;
        if(itens.size() < capacidadeMaxima){
            for (int i = 0; i < itens.size(); i++) {
                if(itens.get(i) == nomeItem){
                    duplicado = true;
                }
            }
            if(duplicado == false){
                itens.add(nomeItem);
            }
        }
    }

    Boolean removerItem(String nomeItem){
        if(itens.contains(nomeItem)){
            itens.remove(nomeItem);
            return true;
        }
        else {
            return false;
        }
    }

    String obterItem(Integer posicao){
        if(posicao >= 0 && posicao < itens.size() ){
            return itens.get(posicao);
        } else {
            return null;
        }
    }

    Boolean substituirItem(Integer posicao, String novoItem){

        if(posicao >= 0 && posicao < itens.size() ){
            if(itens.contains(novoItem)){
                return false;
            }
            itens.set(posicao, novoItem);
            return true;
        } else {
            return false;
        }
    }

    Integer calcularVagasRestantes(){
        return capacidadeMaxima - itens.size();
    }

    String removerItemNaPosicao(Integer posicao){
        if(posicao >= 0 && posicao < itens.size() ){
            String item = itens.get(posicao);
            itens.remove((int) posicao);
            return item;
        }
        else{
            return null;
        }
    }

    Integer removerItensDuplicados() {
        List<String> vistos = new ArrayList<>();
        int removidos = 0;

        int i = 0;
        while (i < itens.size()) {
            String item = itens.get(i);

            if (vistos.contains(item)) {
                itens.remove(i);
                removidos++;
            } else {
                vistos.add(item);
                i++;
            }
        }

        return removidos;
    }
}
