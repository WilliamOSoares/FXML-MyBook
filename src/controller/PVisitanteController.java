//MyBook//
/*******************************************************************************
Autores: Samuel Ramos dos Santos e William Oliveira Soares
Componente Curricular: MI Programação
Concluido em: 29/07/2018
Declaro que este código foi elaborado por nós de forma coletiva e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não seja a nossa está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
***************************************************************************************/
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import main.MyBook;
import model.Postagem;
import model.Usuario;

/**
 * FXML Controler da classe Perfil Visitante.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class PVisitanteController implements Initializable {

    @FXML
    private TextField txBuscarAmigos;
    @FXML
    private Button btBuscar;
    @FXML
    private Button btInicio;
    @FXML
    private Button btSair;
    @FXML
    private ScrollPane panePerfil;
    @FXML
    private ImageView imgPerfil;
    @FXML
    private Button btListarAmigos;
    @FXML
    private Button btListarPostagens;
    @FXML
    private Label lbNomeCompleto;
    @FXML
    private Label lbUsername;
    @FXML
    private ScrollPane paneListarAmigos;
    @FXML
    private ListView<?> lvwAmigos;
    @FXML
    private ScrollPane panePostagens;
    @FXML
    private ListView<String> lvwPostagens;
    @FXML
    private Label lbEmail;
    @FXML
    private Label lbTelefone;
    @FXML
    private Label lbEndereco;
    @FXML
    private Button btAdicionarAmigo;    
    
    Usuario logado = MyBook.getLogado();
    Usuario visitado = MyBook.getVisitado();
    
    private List<String> listPostagens = new ArrayList<>();
    private ObservableList<String> observableListPostagem;
    
    /**
     * Initializes the controller class.
     * @param url url
     * @param rb rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        panePerfil.setDisable(false);
        panePerfil.setVisible(true);
        paneListarAmigos.setDisable(false);
        paneListarAmigos.setVisible(false);
        panePostagens.setDisable(false);
        panePostagens.setVisible(false);        
        Image image = null;            
        try {
            if(visitado.getCaminhoImgPerfil()!=null){
                image = new Image (new FileInputStream(((Usuario) MyBook.getControl().getUsuarios().get(visitado.getLogin())).getCaminhoImgPerfil()));
                
                imgPerfil.setImage(image); 
            }             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelasController.class.getName()).log(Level.SEVERE, null, ex);
            MyBook.erro(10);
        } 
        lbNomeCompleto.setText(visitado.getNomeCompleto());
        lbUsername.setText("@"+visitado.getLogin());
        lbEmail.setText(visitado.getEmail());
        lbTelefone.setText(visitado.getTelefone());
        if(visitado.getEndereco()!= null){
            lbEndereco.setText(visitado.getEndereco().toString());
        }
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
        });
        
        btInicio.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                MyBook.escolherCena(3);
            }
        });
        
        btSair.setOnMouseClicked((MouseEvent e)->{
            MyBook.escolherCena(1);
        });
        
        btSair.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                MyBook.escolherCena(1);
            }
        });
        
        imgPerfil.setOnMouseClicked((MouseEvent e)->{
            
        });
        
        btListarAmigos.setOnMouseClicked((MouseEvent e)->{
            paneListarAmigos.setDisable(false);
            paneListarAmigos.setVisible(true);
            panePostagens.setVisible(false);
        });
        
        btListarAmigos.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                paneListarAmigos.setDisable(false);
                paneListarAmigos.setVisible(true);
                panePostagens.setVisible(false);
            }
        });
        
        btListarPostagens.setOnMouseClicked((MouseEvent e)->{
            panePostagens.setDisable(false);
            panePostagens.setVisible(true);
            paneListarAmigos.setVisible(false);
            lvwPostagens.getItems().clear();
            carregarListPostagens();
            
        });
        
        btListarPostagens.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                panePostagens.setDisable(false);
                panePostagens.setVisible(true);
                paneListarAmigos.setVisible(false);
                lvwPostagens.getItems().clear();
                carregarListPostagens();
            }
        });
        
        btAdicionarAmigo.setOnMouseClicked((MouseEvent e)->{
            addAmigo(logado, visitado);
            btAdicionarAmigo.setDisable(true);
        });
        
        btAdicionarAmigo.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                addAmigo(logado, visitado);
                btAdicionarAmigo.setDisable(true);
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
     * Manda uma solicitação para o outro usuário.
     * @param logado Usuário logado.
     * @param visitado Usuário visitado.
     */
    public void addAmigo(Usuario logado, Usuario visitado){
        MyBook.enviarPedidoAmizade(logado, visitado);    
    } 
    /**
     * Carrega as postagens feitas.
     */
    public void carregarListPostagens(){
        LinkedList linkedList = MyBook.retornarPostagens(visitado.getLogin());
        while(!linkedList.isEmpty()){
            Postagem p = (Postagem) linkedList.remove();
            listPostagens.add(p.toString());            
        }        
        observableListPostagem = FXCollections.observableArrayList(listPostagens);
        lvwPostagens.getItems().clear();
        lvwPostagens.setItems(observableListPostagem);
        listPostagens.clear();
    }
    
}
