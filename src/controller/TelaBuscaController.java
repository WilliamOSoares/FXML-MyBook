/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.MyBook;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author Samuel
 */
public class TelaBuscaController implements Initializable {

    @FXML
    private TextField txBuscarAmigos;
    @FXML
    private Button btBuscar;
    @FXML
    private Button btInicio;
    @FXML
    private Button btSair;
    @FXML
    private ListView<Usuario> lvwBuscaAmigos;
    
    private Usuario[] achados = MyBook.getAchados();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lvwBuscaAmigos.setCellFactory(param -> new TelaBuscaController.Node());
        lvwBuscaAmigos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        Usuario[] users = achados;
        ObservableList resultObservable = FXCollections.observableArrayList(users);
        lvwBuscaAmigos.setItems(resultObservable);
        btBuscar.setOnMouseClicked((MouseEvent e)->{
            buscar(txBuscarAmigos.getText());
        });
        
        btBuscar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                buscar(txBuscarAmigos.getText());
            }
        });
        
        btInicio.setOnMouseClicked((MouseEvent e)->{
            MyBook.escolherCena(3);
            MyBook.salvar();
        });
        
        btInicio.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                MyBook.escolherCena(3);
                MyBook.salvar();
            }
        });
        
        btSair.setOnMouseClicked((MouseEvent e)->{
            MyBook.salvar();
            MyBook.escolherCena(1);
        });
        
        btSair.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                MyBook.salvar();
                MyBook.escolherCena(1);
            }
        });
    }   
    
    
    /**
     * buscar pelo username.
     * @param nome Username.
     */
    public void buscar (String nome){
        if (nome.isEmpty())
            MyBook.erro(2);
        else
            MyBook.buscar(nome);
    }
    /**
    * Visita o usuario clicado.
    */
    public void visitar(){
        Usuario clicado = (Usuario)lvwBuscaAmigos.getSelectionModel().getSelectedItem();
        MyBook.visitar(clicado);
    }
    
    /**
     * Classe da Celula da lista.
     */
    public class Node extends ListCell<Usuario>{    
        @Override
	protected void updateItem(Usuario u, boolean empty) {            
            if (empty || u == null) {
                return ;
            }else{
                super.updateItem(u, empty);
                Image imagem;
                if(!u.getCaminhoImgPerfil().equals("src\\view\\resources\\images\\default_avatar.png"))
                    imagem = new Image(new File(u.getCaminhoImgPerfil()).toURI().toString());
                else
                    imagem = new Image(new File("src\\view\\resources\\images\\default_avatar.png").toURI().toString());                
                ImageView foto = new ImageView(imagem);
                foto.setFitHeight(60);
                foto.setFitWidth(60);
                Label nomeCompleto = new Label(u.getNomeCompleto());              
                HBox caixaHorizontal = new HBox();
                caixaHorizontal.getChildren().addAll(foto, nomeCompleto);            
                caixaHorizontal.setSpacing(20);            
                setText(null);
                setGraphic(caixaHorizontal);
            }
        }    
    }
}
