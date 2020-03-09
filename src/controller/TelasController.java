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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.Busca;
import main.CriarPostagem;
import main.MyBook;
import model.Postagem;
import model.Usuario;

/**
 * FXML Controler da classe perfil.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class TelasController implements Initializable {

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
    private ListView<Usuario> lvwAmigos;
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
    private Button btCriarPostagem;
    @FXML
    private Button btBuscaAvancada;
    @FXML
    private ScrollPane panePedidosP;
    @FXML
    private ListView<Usuario> lvwPedidosP;
    @FXML
    private Button btPedidosPendentes;
    
    Usuario usuario = MyBook.getLogado();
    
    private List<String> listPostagens = new ArrayList<>();
    private ObservableList<String> observableListPostagem;   
    
    /**
     * Initializes the controller class.
     * @param url url
     * @param rb rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = null;            
        try {
            if(usuario.getCaminhoImgPerfil()!=null){
                image = new Image (new FileInputStream(((Usuario) MyBook.getControl().getUsuarios().get(usuario.getLogin())).getCaminhoImgPerfil()));
                
                imgPerfil.setImage(image); 
            }             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelasController.class.getName()).log(Level.SEVERE, null, ex);
            MyBook.erro(10);
        }            
        panePerfil.setDisable(false);
        panePerfil.setVisible(true);
        paneListarAmigos.setDisable(false);
        paneListarAmigos.setVisible(false);
        panePostagens.setDisable(false);
        panePostagens.setVisible(false);
        panePedidosP.setVisible(false);
        panePedidosP.setDisable(false);
        
        lbNomeCompleto.setText(usuario.getNomeCompleto());
        lbUsername.setText("@"+usuario.getLogin());
        lbEmail.setText(usuario.getEmail());
        lbTelefone.setText(usuario.getTelefone());
        if(usuario.getEndereco()!= null){
            lbEndereco.setText(usuario.getEndereco().toString());
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
        
        imgPerfil.setOnMouseClicked((MouseEvent e)->{
            carregarImagemPerfil();
            MyBook.salvar();
        });
        
        btListarAmigos.setOnMouseClicked((MouseEvent e)->{
            paneListarAmigos.setDisable(false);
            paneListarAmigos.setVisible(true);
            panePostagens.setVisible(false);
            panePedidosP.setVisible(false);
            lvwAmigos.setCellFactory(param -> new Node());
            lvwAmigos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            Usuario[] amigos = getAmigos(usuario);
            ObservableList resultObservable = FXCollections.observableArrayList(amigos);
            lvwAmigos.setItems(resultObservable);
            
        });
        
        btListarAmigos.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                paneListarAmigos.setDisable(false);
                paneListarAmigos.setVisible(true);
                panePostagens.setVisible(false);
                panePedidosP.setVisible(false);
                lvwAmigos.setCellFactory(param -> new Node());
                lvwAmigos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                Usuario[] amigos = getAmigos(usuario);
                ObservableList resultObservable = FXCollections.observableArrayList(amigos);
                lvwAmigos.setItems(resultObservable);
            }
        });
        
        btPedidosPendentes.setOnMouseClicked((MouseEvent e)->{
            paneListarAmigos.setDisable(false);
            paneListarAmigos.setVisible(false);
            panePostagens.setVisible(false);
            panePedidosP.setVisible(true);
            lvwPedidosP.setCellFactory(param -> new NodePedido());
            lvwPedidosP.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            Usuario[] amigos = getPedidoAmizade(usuario);
            ObservableList resultObservable = FXCollections.observableArrayList(amigos);
            lvwPedidosP.setItems(resultObservable);
            
        });
        
        btPedidosPendentes.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                paneListarAmigos.setDisable(false);
                paneListarAmigos.setVisible(false);
                panePostagens.setVisible(false);
                panePedidosP.setVisible(true);
                lvwPedidosP.setCellFactory(param -> new NodePedido());
                lvwPedidosP.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                Usuario[] amigos = getPedidoAmizade(usuario);
                ObservableList resultObservable = FXCollections.observableArrayList(amigos);
                lvwPedidosP.setItems(resultObservable);
            }
        });
        
        btListarPostagens.setOnMouseClicked((MouseEvent e)->{
            panePostagens.setDisable(false);
            panePostagens.setVisible(true);
            paneListarAmigos.setVisible(false);
            panePedidosP.setVisible(false);
            lvwPostagens.getItems().clear();
            carregarListPostagens();
        });
        
        btListarPostagens.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                panePostagens.setDisable(false);
                panePostagens.setVisible(true);
                paneListarAmigos.setVisible(false);
                panePedidosP.setVisible(false);
                lvwPostagens.getItems().clear();
                carregarListPostagens();
            }
        });
        
        btCriarPostagem.setOnMouseClicked((MouseEvent e)->{
            criarPost();
        });
        
        btCriarPostagem.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                criarPost();
            }
        });
        
        btBuscaAvancada.setOnMouseClicked((MouseEvent e)->{
            buscaAvancada();
        });
        
        btBuscaAvancada.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                buscaAvancada();
            }
        });
    }
    /**
     * Começa uma busca avançada.
     */
    public void buscaAvancada(){
        Busca busca = new Busca();
        try {
            busca.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(TelasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Começa a criar um post.
     */
    public void criarPost(){
        CriarPostagem criarPost = new CriarPostagem();
        try {
            criarPost.start(new Stage());
        } catch (Exception ex) {
            System.out.println("Erro ao abrir a tela");
        }
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
     * Carrega a imagem do disco rígido para o perfil.
     */
    public void carregarImagemPerfil(){
        String caminho = null;
        File file;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Escolher imagem do perfil.. ");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Todas as imagens","*.*" ),
                                                 new FileChooser.ExtensionFilter("JPG", ".jpg"),
                                                 new FileChooser.ExtensionFilter("PNG", ".png"));
        try{
            file = fileChooser.showOpenDialog(new Stage());
            caminho = file.getAbsolutePath();
            //u.setCaminhoImgPerfil(caminho);
            ((Usuario) MyBook.getControl().getUsuarios().get(usuario.getLogin())).setCaminhoImgPerfil(caminho);
            Image image = new Image (new FileInputStream(((Usuario) MyBook.getControl().getUsuarios().get(usuario.getLogin())).getCaminhoImgPerfil()));
            imgPerfil.setImage(image);            
        }catch(NullPointerException | IOException ex){
            
        }
    }
    
    /**
     * Carrega as postagens feitas.
     */
    public void carregarListPostagens(){
        LinkedList linkedList = MyBook.retornarPostagens(usuario.getLogin());
        while(!linkedList.isEmpty()){
            Postagem p = (Postagem) linkedList.remove();
            listPostagens.add(p.toString());            
        }        
        observableListPostagem = FXCollections.observableArrayList(listPostagens);
        lvwPostagens.getItems().clear();
        lvwPostagens.setItems(observableListPostagem);
        listPostagens.clear();
    }
    /**
     * Pega os amigos do usuario.
     * @param usuario Usuario.
     * @return Array de usuarios.
     */
    public Usuario[] getAmigos(Usuario usuario) {
        return MyBook.getControl().getAmigos(usuario);
    }
    /**
     * Pega os pedidos de amizade do usuario.
     * @param usuario Usuario.
     * @return Array de usuarios.
     */
    public Usuario[] getPedidoAmizade(Usuario usuario){
        return MyBook.getControl().getPedidoAmizade(usuario);
    }
    /**
    * Visita o usuario clicado.
    */
    public void visitar(){
        Usuario clicado = (Usuario)lvwAmigos.getSelectionModel().getSelectedItem();
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
    /**
     * Classe da Celula da lista para pedido de amizade.
     */
    public class NodePedido extends ListCell<Usuario>{    
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
                Button aceitar = new Button("aceitar");
                aceitar.setOnAction(e -> {
                    MyBook.aceitarPedido(u);
                    lvwPedidosP.getItems().remove(u);
                });
                Button recusar = new Button("recusar");
                recusar.setOnAction(e -> {
                    MyBook.recusarPedido(u);
                    lvwPedidosP.getItems().remove(u);
                });
                HBox caixaHorizontal = new HBox();
                caixaHorizontal.getChildren().addAll(foto, nomeCompleto, aceitar, recusar);            
                caixaHorizontal.setSpacing(20);            
                setText(null);
                setGraphic(caixaHorizontal);
            }
        }    
    }
}
