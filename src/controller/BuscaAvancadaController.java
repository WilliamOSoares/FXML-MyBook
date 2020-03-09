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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import main.Busca;
import main.MyBook;

/**
 * FXML Controler da classe de Busca avançada.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class BuscaAvancadaController implements Initializable {

    @FXML
    private TextField txBuscaAvancada;
    @FXML
    private Button btCancelar;
    @FXML
    private Button btBuscaCidade;
    @FXML
    private Button btBuscaUsername;
    @FXML
    private Button btBuscaNome;

    /**
     * Initializes the controller class.
     * @param url url
     * @param rb rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btCancelar.setOnMouseClicked((MouseEvent e)->{
            Busca.getStage().close();
        });
        
        btCancelar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                Busca.getStage().close();
            }
        });
        
        btBuscaCidade.setOnMouseClicked((MouseEvent e)->{
            buscarCidade(txBuscaAvancada.getText());
            Busca.getStage().close();
        });
        
        btBuscaCidade.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                buscarCidade(txBuscaAvancada.getText());
                Busca.getStage().close();
            }
        });
        
        btBuscaUsername.setOnMouseClicked((MouseEvent e)->{
            buscarUserName(txBuscaAvancada.getText());
            Busca.getStage().close();
        });
        
        btBuscaUsername.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                buscarUserName(txBuscaAvancada.getText());
                Busca.getStage().close();
            }
        });
        
        btBuscaNome.setOnMouseClicked((MouseEvent e)->{
            buscarNome(txBuscaAvancada.getText());
            Busca.getStage().close();
        });
        
        btBuscaNome.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                buscarNome(txBuscaAvancada.getText());
                Busca.getStage().close();
            }
        });
    }    
    /**
     * Busca pelo username.
     * @param username Username.
     */
    public void buscarUserName(String username){
        if (username.isEmpty())
            MyBook.erro(2);
        else
            MyBook.buscar(username);
    }
    /**
     * Buscar por nome.
     * @param nome Nome.
     */
    public void buscarNome(String nome){
        if (nome.isEmpty())
            MyBook.erro(2);
        else
            MyBook.buscarNome(nome);  // LIST VIEW
    }
     /**
     * Buscar por cidade.
     * @param cidade Nome da cidade.
     */
    public void buscarCidade(String cidade){
        if (cidade.isEmpty())
            MyBook.erro(2);
        else
            MyBook.buscarCidade(cidade); // LIST VIEW
    }
        
}
