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

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.CriarPostagem;
import main.MyBook;
import model.Postagem;

/**
 * FXML Controler da classe que cria os posts.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class CriarPostsController implements Initializable {

    @FXML
    private TextArea txCriarPost;
    @FXML
    private Button btArquivos;
    @FXML
    private Button btConfirmar;
    @FXML
    private Button btCancelar;
    
    private File file;
    private String caminho;

    /**
     * Initializes the controller class.
     * @param url url
     * @param rb rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btArquivos.setOnMouseClicked((MouseEvent e)->{
            carregarArquivo();
        });
        
        btArquivos.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                carregarArquivo();
            }
        });
        
        btConfirmar.setOnMouseClicked((MouseEvent e)->{
            confirmarPost();
        });
        
        btConfirmar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                confirmarPost();
            }
        });
        
        btCancelar.setOnMouseClicked((MouseEvent e)->{
            CriarPostagem.getStage().close();
        });
        
        btCancelar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                CriarPostagem.getStage().close();
            }
        });
    }    
    /**
     * Confirma o post salvando no disco rígido.
     */
    private void confirmarPost(){
        Postagem postagem = new Postagem();        
        if(caminho!= null){
            postagem.setPostagem(caminho);
        }        
        postagem.setDescricao(txCriarPost.getText());
        MyBook.recebePostagem(postagem);
        CriarPostagem.getStage().close();
    }
    
    /**
     * Carrega o arquivo do disco rígido.
     */
    private void carregarArquivo(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Escolher arquivo.. ");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        try{
            file = fileChooser.showOpenDialog(new Stage());
            caminho = file.getAbsolutePath();
        }catch(NullPointerException ex){
            
        }        
    }
    
}
