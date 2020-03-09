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
package main;

import controller.ControllerGeral;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Postagem;
import model.Usuario;

/**
 * Classe que representa a interface gráfica do login, cadastro e perfil.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class MyBook extends Application{
    private static Stage stage;
    private static Scene loginScene;
    private static Scene cadastroScene;
    private static Scene perfilScene;  
    private static ControllerGeral control = new ControllerGeral();
    private static Usuario logado = new Usuario();
    private static Usuario visitado = new Usuario();
    private static Usuario[] achados = new Usuario[2];
    /**
     * Pega o controller geral.
     * @return ControllerGeral.
     */
    public static ControllerGeral getControl() {
        return control;
    }    
    /**
     * Salva as estruturas de dados no disco rígido.
     */
    public static void salvar(){
        control.salvar();
    }
    /**
     * Usuário visitado na rede social.
     * @return Usuário visitado.
     */
    public static Usuario getVisitado(){
        return visitado;
    }
    /**
     * Usuário logado na rede social.
     * @return Usuário logado.
     */
    public static Usuario getLogado() {
        return logado;
    }
    public static Usuario[] getAchados(){
        return achados;
    }
    /**
     * Recebe a postagem feita pelo usuário para ser gravada no disco rígido.
     * @param post Postagem do usuário.
     */
    public static void recebePostagem(Postagem post){
        control.salvarPostArquivo(logado.getLogin(), post);
    }
    /**
     * Retorna um ArrayList com as postagens do usuario que foi passado por parametro
     * @param nomeUsuario
     * @return 
     */
    public static LinkedList retornarPostagens(String nomeUsuario){
        return control.lerPosts(nomeUsuario);
    }
    
    /**
     * Metódo que torna a classe executável e mostra gráficamente a interface.
     * @param args Argumentos.
     */
    public static void main(String[] args) {
        launch();
    }
    /**
     * Confirma o cadastro de um novo usuário.
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
    public static void confirmarCadastro(String login, String senha, String nome, String email, String dataNasci, String cidade, String estado, String pais, String tell) {
        int i = control.confirmarCadastro(login, senha, nome, email, dataNasci, cidade, estado, pais, tell);
        switch (i) {
            case 1:
                erro(6);
                escolherCena(1);
                break;
            case 2:
                erro(2);
                break;
            default:
                erro(3);
                break;
        }
    }
    /**
     * Verifica se é possível fazer login.
     * @param login Username do usuário.
     * @param senha Senha do usuário.
     */
    public static void fazerLogin(String login, String senha) {
        if(control.fazerLogin(login, senha)){
            logado = control.getLogado();
            escolherCena(3);
        }           
    }
    
    /**
     * Envia o pedido de amizade para o outro usuário.
     * @param logado Usuário logado.
     * @param visitado Usuário visitado.
     */
    public static void enviarPedidoAmizade(Usuario logado, Usuario visitado){
        if(control.enviarPedidoAmizade(logado, visitado))
            erro(7);
        else
            erro(8);
    }
    
    /**
     * Busca pelo username.
     * @param nome Username.
     */
    public static void buscar(String nome){
        visitado = control.buscar(nome);
        if(visitado != null)
            escolherCena(4);
        else
            erro(4);
    }    
    /**
     * Busca pelo nome.
     * @param nome nome.
     */
    public static void buscarNome(String nome) {
        achados = control.buscarNome(nome);
        if(achados.length > 0)    
            escolherCena(5);
        else
            erro(4);
    }
    /**
     * Busca pela cidade.
     * @param cidade Username.
     */
    public static void buscarCidade(String cidade) {
        achados = control.buscarCidade(cidade);
        if(achados.length > 0)    
            escolherCena(5);
        else
            erro(4);
    }
    /**
     * Abre o perfil do visitante;
     * @param usuario Usuario visitado.
     */
    public static void visitar(Usuario usuario){
        visitado = usuario;
        escolherCena(4);    
    }
    /**
     * Aceita o pedido de amigo.
     * @param novoAmigo Novo amigo.
     */
    public static void aceitarPedido(Usuario novoAmigo) {
        control.aceitarPedido(novoAmigo, logado);
    }
    /**
     * recusa o pedido de amigo.
     * @param inimigo Não amigo.
     */
    public static void recusarPedido(Usuario inimigo) {
        control.recusarPedido(inimigo, logado);
    }
    
    /**
     * Metódo que mostra os erros de acordo com o codígo pelo parâmetro.
     * @param arg codígo do erro.
     */
    public static void erro(int arg){
        switch (arg) {
            case 1:
                {                    
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setContentText("Algum campo não foi preenchido corretamente!!");
                    alert.show();
                    break;
                }
            case 2:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setContentText("Preencha todos os dados!!");
                    alert.show();
                    break;
                }
            case 3:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setContentText("Usuario já existe!!");
                    alert.show();
                    break;
                }
            case 4:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setContentText("Nome de usuário não encontrado!!");
                    alert.show();
                    break;
                }
            case 5:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setContentText("Senha incorreta!!");
                    alert.show();
                    break;
                }
            case 6:
                {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Concluído");
                    alert.setContentText("Usuário Cadastrado!!");
                    alert.show();
                    break;
                }                
            case 7:
                {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Concluído");
                    alert.setContentText("Pedido enviado!!");
                    alert.show();
                    break;
                }
            case 8:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setContentText("Você já fez isso!!");
                    alert.show();
                    break;
                }
            default:
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erro");
                    alert.setContentText("Ocorreu um erro inesperado!!");
                    alert.show();
                    break;
                }
        }
    }

    @Override
    public void start(Stage palco) throws Exception {
        stage = palco;
        palco.setTitle("MyBook");
        Parent login = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        loginScene = new Scene(login);
        
        Parent cadastro = FXMLLoader.load(getClass().getResource("/view/Cadastro.fxml"));
        cadastroScene = new Scene(cadastro);
        
        Parent perfil = FXMLLoader.load(getClass().getResource("/view/Telas.fxml"));
        perfilScene = new Scene(perfil);
        
        palco.setScene(loginScene);
        palco.show();
    }
    /**
     * Escolhe a cena que irá aparecer apartir do codigo que foi recebido por 
     * parâmetro.
     * @param scene Codigo da cena que será mostrado.
     */
    public static void escolherCena(int scene){
        switch(scene){
            case 1: 
                stage.setTitle("MyBook - Login");
                stage.setScene(loginScene);
            break;
            
            case 2:
                stage.setTitle("MyBook - Cadastro");
                stage.setScene(cadastroScene);
            break;
            
            case 3:
                Perfil perfil = new Perfil();
                stage.setTitle("MyBook - Perfil");         
                try {
                    perfil.perfil();
                } catch (Exception ex) {
                    erro(10);
                }
                perfilScene = perfil.getCena();
                stage.setScene(perfilScene);
            break;
            
            case 4:
                PerfilVisitante visitante = new PerfilVisitante();
                stage.setTitle("MyBook");
                try{
                    visitante.perfilVisitante();
                }catch(Exception ex){
                    erro(10);
                }
                stage.setScene(visitante.getCena());
            break;
            
            case 5:
                TelaBusca busca = new TelaBusca();
                stage.setTitle("MyBook - Busca");
                try{
                    busca.abrirTelaBusca();
                }catch(Exception ex){
                    erro(10);
                }
                stage.setScene(busca.getCena());
            break;
        }
    }
}
