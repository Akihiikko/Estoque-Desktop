package com.amanda.estoque.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EstoqueDAO {

    private static EstoqueDAO instancia;
    private final ObservableList<Produto> listaProdutos;
    private int idProduto = 1;


    private EstoqueDAO() {
        this.listaProdutos = FXCollections.observableArrayList();
    }


    public static EstoqueDAO getInstancia() {
        if (instancia == null) {
            instancia = new EstoqueDAO();
        }
        return instancia;
    }

    public void adicionar(Produto produto) {
        produto.setId(idProduto++);
        listaProdutos.add(produto);
    }

    public ObservableList<Produto> listarProdutos() {
        return listaProdutos;
    }

    public void remover(Produto produto) {
        listaProdutos.remove(produto);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = produtosList.stream().mapToDouble(Produto::getValorTotal).sum;
    }

    public long calcularEstoqueBaixo(int limite){
        return produtosList.stream().filter(Produto p -> p.getQuantidade() < limite).count();
    }
}

