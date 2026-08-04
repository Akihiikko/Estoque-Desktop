package com.amanda.estoque;

import com.amanda.estoque.model.EstoqueDAO;
import com.amanda.estoque.model.Produto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.NumberFormat;
import java.util.Locale;

public class RelatorioController {
    @FXML
    private Label lblTotalProdutos;

    @FXML
    private Label lblValorTotal;

    @FXML
    private Label lblEstoqueBaixo;

    private final EstoqueDAO dadosEstoque = EstoqueDAO.getInstancia();

    @FXML
    public void initialize(){

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));

        int totalProdutos = dadosEstoque.listarProdutos().size();
        lblTotalProdutos.setText(String.valueOf(totalProdutos));

        double valorTotalEstoque = dadosEstoque.calcularValorTotalEstoque();
        lblValorTotal.setText(formatoMoeda.format(valorTotalEstoque));

        long estoqueBaixo = dadosEstoque.calcularEstoqueBaixo(10);
        lblEstoqueBaixo.setText(String.valueOf(estoqueBaixo));

        // Conversao de tipos

        // Inteiro ou Double para String -> String.valueOf(numero)
        // String dou Double para Inteiro -> Interger.parseInt(string)
        // Inteiro ou String para double -> Double.parseDouble(`8.5`)
        // String para boolean -> Bollean.parseBoolean("true")
  }
}
