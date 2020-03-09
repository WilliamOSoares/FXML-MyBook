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
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import main.MyBook;


/**
 * FXML Controler da classe cadastro.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class CadastroController implements Initializable {

    @FXML
    private TextField txUser;
    @FXML
    private PasswordField txSenha;
    @FXML
    private TextField txNomeCompleto;
    @FXML
    private TextField txEmail;
    @FXML
    private DatePicker dtDataNascimento;
    @FXML
    private TextField txCidade;
    @FXML
    private TextField txEstado;
    @FXML
    private TextField txPais;
    @FXML
    private TextField txTelefone;
    @FXML
    private Button btConfirmar;
    @FXML
    private Button btCancelar;

    /**
     * Initializes the controller class.
     * @param url url
     * @param rb rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btConfirmar.setOnMouseClicked((MouseEvent e) -> {
            try{
                confirmarCadastro(txUser.getText(), txSenha.getText(),txNomeCompleto.getText(),
                              txEmail.getText(), dtDataNascimento.getValue().format(DateTimeFormatter.ISO_DATE),
                              txCidade.getText(), txEstado.getText(), txPais.getText(), txTelefone.getText());
                limpar();
            } catch (NullPointerException ex){
                MyBook.erro(1);
            }
        });
        
        btConfirmar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                try{
                    confirmarCadastro(txUser.getText(), txSenha.getText(),txNomeCompleto.getText(),
                                  txEmail.getText(), dtDataNascimento.getValue().format(DateTimeFormatter.ISO_DATE),
                                  txCidade.getText(), txEstado.getText(), txPais.getText(), txTelefone.getText());
                    limpar();
                } catch (NullPointerException ex){
                    MyBook.erro(1);
                }
            }
        });
        
        btCancelar.setOnMouseClicked((MouseEvent e) -> {
            MyBook.escolherCena(1);
            limpar();
        });
        
        btCancelar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                MyBook.escolherCena(1);
                limpar();
            }
        });
    }
    /**
     * Cofirma o cadastro de um novo usuário.
     * @param login UserName do usuário.
     * @param senha Senha do usuário.
     * @param nome Nome completo do usuário.
     * @param email Endereço eletrônico do usuário.
     * @param dataNasci Data de nascimento do usuário.
     * @param cidade Cidade do usuário.
     * @param estado Estado do usuário.
     * @param pais País do usuário.
     * @param tell Telefone do usuário.
     */
    public void confirmarCadastro(String login, String senha, String nome, String email, String dataNasci, String cidade, String estado, String pais, String tell) {
        MyBook.confirmarCadastro(login, senha, nome, email, dataNasci, cidade, estado, pais, tell);
    }
    /**
     * Limpa a tela dos dados recem colocados.
     */
    private void limpar (){
        txUser.setText(null);
        txSenha.setText(null);
        txNomeCompleto.setText(null);
        txEmail.setText(null);
        dtDataNascimento.setValue(null);
        txCidade.setText(null);
        txEstado.setText(null); 
        txPais.setText(null);
        txTelefone.setText(null);
    }
    
}
