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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import main.MyBook;

/**
 * FXML Controler da classe login.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txNomeUsuario;
    @FXML
    private PasswordField txSenha;
    @FXML
    private Button btEntrar;
    @FXML
    private Button btCadastrar;

    /**
     * Initializes the controller class.
     * @param url url
     * @param rb rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btEntrar.setOnMouseClicked((MouseEvent e) -> {
            try {
                logar();
            } catch(NullPointerException ex){
                MyBook.erro(1);
            }
            limpar();
        });
        
        btEntrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                try {
                    logar();
                } catch(NullPointerException ex){
                    MyBook.erro(1);
                }
                limpar();
            }
        });
        
        txSenha.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                logar();
                limpar();
            }
        });
        
        btCadastrar.setOnMouseClicked((MouseEvent e) -> {
            MyBook.escolherCena(2);
            limpar();
        });
        
        btCadastrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                MyBook.escolherCena(2);
                limpar();
            }
        });
    }    
    /**
     * Limpa a tela dos dados recem colocados.
     */
    private void limpar (){
        txNomeUsuario.setText(null);
        txSenha.setText(null);
    }
    /**
     * Começa a fazer o login.
     */
    public void logar() {
        if(txNomeUsuario.getText().isEmpty() || txSenha.getText().isEmpty())
            MyBook.erro(2);
        else 
            MyBook.fazerLogin(txNomeUsuario.getText(), txSenha.getText());
    }
    
}
