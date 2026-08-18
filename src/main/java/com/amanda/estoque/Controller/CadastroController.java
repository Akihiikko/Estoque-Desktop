package com.amanda.estoque.Controller;

import com.amanda.estoque.model.Usuario;
import com.amanda.estoque.model.UsuarioDAO;
import com.amanda.estoque.util.Constantes;
import com.amanda.estoque.util.GerenciadorTela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;

import java.io.IOException;


public class CadastroController {

    @FXML
    private TextField usuarioCadastrar;

    @FXML
    private PasswordField senhaCadastrar;

    @FXML
    private PasswordField confirmaSenha;

    @FXML
    private Label usuarioInvalido;

    @FXML
    private  Label senhaInvalida;

    @FXML
    private TextFlow erroSenha;

    private static UsuarioDAO dbUsuario = UsuarioDAO.getInstancia();

    @FXML
    protected  void aoConfirmarCadastro(ActionEvent event) throws IOException {

        String usuario =  usuarioCadastrar.getText();

        String regexEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

        String regexSenha = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{6,}$";

        if(usuario.isBlank() || !usuario.matches(Constantes.REGEX_EMAIL.getValor())){
            usuarioInvalido.setVisible(true);
            return;
        }

        String senha =  senhaCadastrar.getText();
        if(senha.isBlank() || !senha.matches(Constantes.REGEX_SENHA.getValor())){
            senhaInvalida.setVisible(true);
            return;
        }

        String senhaConfirmacao = confirmaSenha.getText();
        if(!senhaConfirmacao.equals(senha)){
            erroSenha.setVisible(true);
            return;
        }
        Usuario novoUsuario =  new Usuario(usuario, senha);
        dbUsuario.cadastrarUsuario(novoUsuario);

        GerenciadorTela.getInstancia().trocarTela(event, "login.fxml", "Sistema de Estoque - Login");
    }

    @FXML
    protected void  aoAcessarLogin(MouseEvent event) throws IOException {
        GerenciadorTela.getInstancia().trocarTela(event, "login.fxml", "Sistema de Estoque - Login");

    }
}