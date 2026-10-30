package school.sptech;

import jdk.jshell.DeclarationSnippet;
import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.awt.*;
import java.beans.beancontext.BeanContextMembershipListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if(this.desenvolvedores.size() >= this.vagas){
            return;
        }
        else{
            this.desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            contratar(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double soma = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            soma = soma + desenvolvedor.calcularSalario();
        }
        return soma;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer quantidade = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor instanceof DesenvolvedorMobile desenvolvedorMobile){
                quantidade++;
            }
        }
        return quantidade;
    }

    public List<DesenvolvedorWeb> getDesenvolvedoresWeb(){
        List<DesenvolvedorWeb> listaDesenvolvedores = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor instanceof DesenvolvedorWeb desenvolvedorWeb){
                listaDesenvolvedores.add(desenvolvedorWeb);
            }
        }
        return listaDesenvolvedores;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> listaDesenvolvedores = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor.calcularSalario() >= salario){
                listaDesenvolvedores.add(desenvolvedor);
            }
        }
        return listaDesenvolvedores;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(this.desenvolvedores.isEmpty()){
            return null;
        }
        else{
            Desenvolvedor menorSalario = desenvolvedores.getFirst();
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if(menorSalario.calcularSalario() > desenvolvedor.calcularSalario()){
                    menorSalario = desenvolvedor;
                }
            }
            return menorSalario;
        }
    }

    public Double calcularMediaSalarial(){
        if(desenvolvedores.size() > 0){
            Double soma = 0.0;
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                soma = soma + desenvolvedor.calcularSalario();
            }
            Double media = soma / desenvolvedores.size();
            return media;
        }
        return 0.0;
    }

    public List<Desenvolvedor> buscarPorNome(String nome){
        List<Desenvolvedor> listaDesenvolvedores = new ArrayList<>();
         if(desenvolvedores.size() > 0){
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if(desenvolvedor.getNome().toLowerCase().contains(nome.toLowerCase())){
                    listaDesenvolvedores.add(desenvolvedor);
                }
            }
         }
        return listaDesenvolvedores;
    }

    public Double calcularMediaSalarialPorTipo(String tipo){
        Double soma = 0.0;
        Integer quantidade = 0;
        if(desenvolvedores.size() > 0){
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if(tipo == "comum"){
                    if(desenvolvedor instanceof  DesenvolvedorMobile desenvolvedorMobile || desenvolvedor instanceof DesenvolvedorWeb desenvolvedorWeb){
                        continue;
                    }
                    else {
                        soma = soma + desenvolvedor.calcularSalario();
                        quantidade++;
                    }
                } else if (tipo == "web") {
                    if(desenvolvedor instanceof DesenvolvedorWeb desenvolvedorWeb){
                        soma = soma + desenvolvedor.calcularSalario();
                        quantidade++;
                    }
                } else if (tipo == "mobile") {
                    if(desenvolvedor instanceof DesenvolvedorMobile desenvolvedorMobile){
                        soma = soma + desenvolvedor.calcularSalario();
                        quantidade++;
                    }
                }
                else{
                    return null;
                }
            }
        }
        if(quantidade > 0){
            return soma / quantidade;
        }
        else{
            return 0.0;
        }
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> listaDesenvolvedores = new ArrayList<>();
        if(this.desenvolvedores.size() > 0 ){
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if(desenvolvedor instanceof DesenvolvedorWeb desenvolvedorWeb){
                    if(desenvolvedorWeb.getFrontend().equalsIgnoreCase(tecnologia)){
                        listaDesenvolvedores.add(desenvolvedor);
                    } else if (desenvolvedorWeb.getBackend().equalsIgnoreCase(tecnologia)) {
                        listaDesenvolvedores.add(desenvolvedor);
                    } else if (desenvolvedorWeb.getSgbd().equalsIgnoreCase(tecnologia)) {
                        listaDesenvolvedores.add(desenvolvedor);
                    }
                } else if (desenvolvedor instanceof DesenvolvedorMobile desenvolvedorMobile) {
                    if(desenvolvedorMobile.getPlataforma().equalsIgnoreCase(tecnologia)){
                        listaDesenvolvedores.add(desenvolvedor);
                    } else if (desenvolvedorMobile.getLinguagem().equalsIgnoreCase(tecnologia)) {
                        listaDesenvolvedores.add(desenvolvedor);
                    }
                }
            }
        }
        return listaDesenvolvedores;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double soma = 0.0;
        if(this.desenvolvedores.size() > 0 ){
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if(desenvolvedor instanceof DesenvolvedorWeb desenvolvedorWeb){
                    if(desenvolvedorWeb.getFrontend().equalsIgnoreCase(tecnologia)){
                        soma = soma + desenvolvedor.calcularSalario();
                    } else if (desenvolvedorWeb.getBackend().equalsIgnoreCase(tecnologia)) {
                        soma = soma + desenvolvedor.calcularSalario();
                    } else if (desenvolvedorWeb.getSgbd().equalsIgnoreCase(tecnologia)) {
                        soma = soma + desenvolvedor.calcularSalario();
                    }
                } else if (desenvolvedor instanceof DesenvolvedorMobile desenvolvedorMobile) {
                    if(desenvolvedorMobile.getPlataforma().equalsIgnoreCase(tecnologia)){
                        soma = soma + desenvolvedor.calcularSalario();
                    } else if (desenvolvedorMobile.getLinguagem().equalsIgnoreCase(tecnologia)) {
                        soma = soma + desenvolvedor.calcularSalario();
                    }
                }
            }
        }
        return soma;
    }

    public String buscarTipoComMaiorMediaSalarial(){
        String resposta = null;
        Double somaComum = 0.0;
        Integer qtdComum = 0;
        Double somaWeb = 0.0;
        Integer qtdWeb = 0;
        Double somaMobile = 0.0;
        Integer qtdMobile = 0;

        if(this.desenvolvedores.size() > 0 ){
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if(desenvolvedor instanceof DesenvolvedorWeb desenvolvedorWeb){
                    somaWeb = somaWeb + desenvolvedorWeb.calcularSalario();
                    qtdWeb++;
                } else if (desenvolvedor instanceof DesenvolvedorMobile desenvolvedorMobile) {
                    somaMobile = somaMobile + desenvolvedorMobile.calcularSalario();
                    qtdMobile++;
                }
                else{
                    somaComum = somaComum + desenvolvedor.calcularSalario();
                    qtdComum++;
                }
            }
            Double mediaWeb = 0.0;
            Double mediaMobile = 0.0;
            Double mediaComum = 0.0;
            if(qtdComum > 0){
                mediaComum = somaComum / qtdComum;
            }
            if (qtdWeb > 0){
                mediaWeb = somaWeb / qtdWeb;
            }
            if(qtdMobile > 0){
                mediaMobile = somaMobile / qtdMobile;
            }

            if(mediaComum > mediaWeb && mediaComum > mediaMobile){
                resposta = "comum";
            }
            else if(mediaMobile > mediaComum && mediaMobile > mediaWeb){
                resposta =  "mobile";
            }
            else if(mediaWeb > mediaComum && mediaWeb > mediaMobile){
                resposta = "web";
            }
        }
        return resposta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return "Consultoria{" +
                "nome='" + nome + '\'' +
                ", vagas=" + vagas +
                ", desenvolvedores=" + desenvolvedores +
                '}';
    }
}
