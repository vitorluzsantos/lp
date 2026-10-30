package school.sptech;

import school.sptech.exceptions.DadoInvalidoException;
import school.sptech.exceptions.ItemIndisponivelException;
import school.sptech.exceptions.ItemNaoEncontradoException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteca {
    private String nome;
    private List<ItemBiblioteca> itens;

    public Biblioteca(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new DadoInvalidoException("nome é invalido ou nulo");
        }
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemBiblioteca item) {
        if (item == null) {
            throw new DadoInvalidoException("item é nulo");
        }
        itens.add(item);
    }

    public ItemBiblioteca buscarPorTitulo(String titulo) {
        for (ItemBiblioteca item : itens) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }
        throw new ItemNaoEncontradoException("item não encontrado");
    }

    public void emprestarItem(String titulo, Usuario usuario) {
        if (titulo == null || usuario == null) {
            throw new DadoInvalidoException("usuario ou titulo nulo");
        }

        ItemBiblioteca item = buscarPorTitulo(titulo);

        try {
            item.emprestar(usuario);
        } catch (ItemIndisponivelException e) {
            System.out.println("Esse item já está emprestado para outro usuário.");
        }
    }

    public void devolverItem(String titulo) {
        if (titulo == null) {
            throw new DadoInvalidoException("titulo nulo");
        }

        ItemBiblioteca item = buscarPorTitulo(titulo);
        item.devolver();
    }

    public Boolean possuiItemDisponivel(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new DadoInvalidoException("titulo é invalido ou nulo");
        }

        ItemBiblioteca item = buscarPorTitulo(titulo);
        return item.getEmprestadoPara() == null;
    }

    public List<ItemBiblioteca> listarDisponiveis() {
        List<ItemBiblioteca> disponiveis = new ArrayList<>();
        for (ItemBiblioteca item : itens) {
            if (item.getEmprestadoPara() == null) {
                disponiveis.add(item);
            }
        }
        return disponiveis;
    }

    public Integer contarPorTipo(String tipo) {
        validarTipo(tipo);

        Integer quantidade = 0;
        for (ItemBiblioteca item : itens) {
            if (ehDoTipo(item, tipo)) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public Integer calcularPrazoMedioEmprestimo() {
        if (itens.isEmpty()) {
            return 0;
        }

        Integer soma = 0;
        for (ItemBiblioteca item : itens) {
            soma += item.getPrazoEmprestimoDias();
        }
        return soma / itens.size();
    }

    public Integer calcularPrazoMedioPorTipo(String tipo) {
        validarTipo(tipo);

        Integer soma = 0;
        Integer quantidade = 0;
        for (ItemBiblioteca item : itens) {
            if (ehDoTipo(item, tipo)) {
                soma += item.getPrazoEmprestimoDias();
                quantidade++;
            }
        }

        if (quantidade == 0) {
            return 0;
        }
        return soma / quantidade;
    }

    public List<ItemBiblioteca> listarEmprestadosPara(Usuario usuario) {
        if (usuario == null) {
            throw new DadoInvalidoException("usuario nulo");
        }

        List<ItemBiblioteca> emprestados = new ArrayList<>();
        for (ItemBiblioteca item : itens) {
            if (estaEmprestadoPara(item, usuario)) {
                emprestados.add(item);
            }
        }
        return emprestados;
    }

    public void devolverTodosDoUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new DadoInvalidoException("usuario nulo");
        }

        for (ItemBiblioteca item : itens) {
            if (estaEmprestadoPara(item, usuario)) {
                item.devolver();
            }
        }
    }

    public void emprestarVarios(List<String> titulos, Usuario usuario) {
        if (titulos == null || usuario == null || titulos.isEmpty()) {
            throw new DadoInvalidoException("titulos ou usuario invalido");
        }

        Set<String> vistos = new HashSet<>();
        for (String titulo : titulos) {
            if (titulo == null || titulo.isBlank()) {
                throw new DadoInvalidoException("titulo é invalido ou nulo");
            }
            if (!vistos.add(titulo.toLowerCase())) {
                throw new DadoInvalidoException("titulos duplicados");
            }
        }

        List<ItemBiblioteca> encontrados = new ArrayList<>();
        for (String titulo : titulos) {
            encontrados.add(buscarPorTitulo(titulo));
        }

        for (ItemBiblioteca item : encontrados) {
            if (item.getEmprestadoPara() != null) {
                System.out.println("Não foi possível emprestar o lote: o item '"
                        + item.getTitulo() + "' está indisponível.");
                return;
            }
        }

        for (ItemBiblioteca item : encontrados) {
            try {
                item.emprestar(usuario);
            } catch (ItemIndisponivelException e) {
                System.out.println("Não foi possível emprestar o lote: o item ‘"
                        + item.getTitulo() + "’ está indisponível.");
            }
        }
    }

    private void validarTipo(String tipo) {
        if (tipo == null || tipo.isBlank()
                || !(tipo.equalsIgnoreCase("DVD") || tipo.equalsIgnoreCase("Livro"))) {
            throw new DadoInvalidoException("tipo é invalido ou nulo");
        }
    }

    private Boolean ehDoTipo(ItemBiblioteca item, String tipo) {
        if (tipo.equalsIgnoreCase("DVD")) {
            return item instanceof Dvd;
        }
        return item instanceof Livro;
    }

    private Boolean estaEmprestadoPara(ItemBiblioteca item, Usuario usuario) {
        return item.getEmprestadoPara() != null
                && item.getEmprestadoPara().getNome().equals(usuario.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemBiblioteca> getItens() {
        return itens;
    }

    public void setItens(List<ItemBiblioteca> itens) {
        this.itens = itens;
    }
}