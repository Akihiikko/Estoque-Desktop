package com.jociel.estoque;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label textoNaTela;

    @FXML
    protected void aoApertarBotao() {
        textoNaTela.setText("Seja bem vindo a primeira tela do Jociel!");
    }
}
