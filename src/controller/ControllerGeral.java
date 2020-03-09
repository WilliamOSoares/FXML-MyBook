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

import exceptions.CampoNaoPreenchidoException;
import exceptions.UsuarioExistenteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.MyBook;
import model.Postagem;
import model.Usuario;
import util.MyArray;
import util.TabelaHash;
/**
 * Classe que controla as outras.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class ControllerGeral {
    private ControllerUsuario users;
    private ControllerArquivo gerenciadorArq;
    private TabelaHash usuarios; // Grafo.
    private Usuario logado;
    /**
     * Construtor que verifica se já tem dados referente a ele no disco rígido,
     * se estiver ele carrega para a memória, se não ele cria novos objetos para
     * os parâmetros.
     */
    public ControllerGeral(){
        users = new ControllerUsuario();
        gerenciadorArq = new ControllerArquivo();
        usuarios = new TabelaHash();
        gerenciadorArq.dirArmazenarUsuarios();
        gerenciadorArq.armazenarOutrosArquivos(); 
        if(gerenciadorArq.lerHashTable()!= null){
            usuarios = gerenciadorArq.lerHashTable();
        }
        if(gerenciadorArq.lerLinkedHS()!= null){
            users.setUsuarios(gerenciadorArq.lerLinkedHS());
        }
        
    }
    /**
     * Salva as estruturas de dados no disco rígido.
     */
    public void salvar(){
        gerenciadorArq.salvarHashTable(usuarios);
        gerenciadorArq.salvarLinkedHS(users.getUsuarios());
    }
    /**
     * Pega o Grafo do sistema.
     * @return HashTable.
     */
    public TabelaHash getUsuarios() {
        return usuarios;
    }   
    
    /**
     * Salva os posts no disco rígido.
     * @param user Usuário que fez a postagem.
     * @param post Postagem.
     */
    public void salvarPostArquivo(String user, Postagem post){
        gerenciadorArq.adicionarPosts(user, post);
    }
    /**
     * Ler as postagens que estao no disco rigido.
     * @param nomeUsuario
     * @return retorna um ArrayList com as postagens
     */
    public LinkedList lerPosts(String nomeUsuario){
        LinkedList linkedLst = new LinkedList();
        try {
            linkedLst = gerenciadorArq.lerPosts(nomeUsuario);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerGeral.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linkedLst;
    }
    /**
     * Pega o usuário logado.
     * @return Usuário.
     */
    public Usuario getLogado() {
        return logado;
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
     * @return 1 se ocorreu como esperado, 2 se um campo não foi preenchido e
     * 3 se o usuário já existe.
     */
    public int confirmarCadastro(String login, String senha, String nome, String email, String dataNasci, String cidade, String estado, String pais, String tell) {
        try{
            Usuario u = users.confirmarCadastro(login, senha, nome, email, dataNasci, cidade, estado, pais, tell);
            if(u != null){
                usuarios.put(u.getLogin(), u);
                gerenciadorArq.criarDiretorioUsuario(u.getLogin());
                salvar();
            }
            return 1;
        } catch(CampoNaoPreenchidoException ex){
            return 2;
        } catch (UsuarioExistenteException ex) {
            return 3;
        } 
    }
    /**
     * Faz o login.
     * @param nome Username.
     * @param senha Senha.
     * @return True se consiguir logar, senão False.
     */
    public boolean fazerLogin(String nome, String senha){
        if(!users.existeUser(nome)){
            MyBook.erro(4);
            return false;
        }
        Usuario u = (Usuario) usuarios.get(nome);
        
        if(u.getSenha().equals(senha)){
            logado = u;
            return true;
        }else{
            MyBook.erro(5);
            return false;
        }    
    }
    /**
     * Busca pelo username.
     * @param username Username.
     * @return True se achou, senão False.
     */
    public Usuario buscar(String username){
        if(!users.existeUser(username)){
            MyBook.erro(4);
            return null;
        } else if(username.equals(logado.getLogin())){
            return null;
        } else {
            Usuario u = (Usuario) usuarios.get(username);
            return u;
        }
    }
    /**
     * Buscar por nome.
     * @param nome Nome.
     * @return Array de usuarios.
     */
    public Usuario[] buscarNome(String nome) {
        if(!usuarios.isEmpty()){
            nome = nome.toLowerCase();
            String nomeUsuario;
            ArrayList<Usuario> achados = new ArrayList<>();
            Iterator it = usuarios.getIterador();
            while(it.hasNext()){
                Usuario u = (Usuario) it.next();
                nomeUsuario = u.getNomeCompleto().toLowerCase();
                if(nomeUsuario.contains(nome) && !u.equals(logado)){
                    achados.add(u);
                }
            }
            Usuario[] u = new Usuario[achados.size()];
            return achados.toArray(u);
        }
        return null;
    }
    /**
     * Buscar por cidade.
     * @param cidade Nome da cidade.
     * @return Array de usuario.
     */
    public Usuario[] buscarCidade(String cidade) {
        if(!usuarios.isEmpty()){
            cidade = cidade.toLowerCase();
            String cidadeUsuario;
            ArrayList<Usuario> achados = new ArrayList<>();
            Iterator it = usuarios.getIterador();
            while(it.hasNext()){
                Usuario u = (Usuario) it.next();
                cidadeUsuario = u.getEndereco().getCidade().toLowerCase();
                if(cidadeUsuario.contains(cidade) && !u.equals(logado)){
                    achados.add(u);
                }
            }
            Usuario[] u = new Usuario[achados.size()];
            return achados.toArray(u);
        }
        return null;
    }
    
    /**
     * Envia o pedido de amizade para o outro usuário.
     * @param logado Usuário logado.
     * @param visitado Usuário visitado.
     * @return True se consiguir, senão false.
     */
    public boolean enviarPedidoAmizade(Usuario logado, Usuario visitado){
        if(logado.getAmigos().get(visitado.getLogin()) != null){
            return false;
        } else if (logado.getPedidosAmizade().get(visitado.getLogin()) != null) {
            return false;
        } else {
            visitado.getPedidosAmizade().put(logado.getLogin(), logado);
            return true;
        }
    }
    /**
     * Pega os amigos do usuario.
     * @param usuario Usuario.
     * @return Array de usuario
     */
    public Usuario[] getAmigos(Usuario usuario) {
        ArrayList<Usuario> amigos = new ArrayList<>();
        Iterator it = usuario.getAmigos().getIterador();
        while(it.hasNext()){
            Usuario pego = (Usuario) it.next();
            amigos.add(pego);
        }
        Usuario[] retorno = new Usuario[amigos.size()];
        return amigos.toArray(retorno);
    }
    /**
     * Pega os pedidos de amizade do usuario.
     * @param usuario Usuario.
     * @return Array de usuario 
     */
    public Usuario[] getPedidoAmizade(Usuario usuario) {
        ArrayList<Usuario> amigos = new ArrayList<>();
        Iterator it = usuario.getPedidosAmizade().getIterador();
        while(it.hasNext()){
            Usuario pego = (Usuario) it.next();
            amigos.add(pego);
        }
        Usuario[] retorno = new Usuario[amigos.size()];
        return amigos.toArray(retorno);
    }
    
    /**
     * Aceita o pedido de amigo.
     * @param novoAmigo Novo amigo.
     * @param logado Usuario logado.
     */
    public void aceitarPedido(Usuario novoAmigo, Usuario logado) {
        logado.getAmigos().put(novoAmigo.getLogin(), novoAmigo);
        logado.getPedidosAmizade().removeKey(novoAmigo.getLogin());
        novoAmigo.getAmigos().put(logado.getLogin(), logado);
    }
    /**
     * recusa o pedido de amigo.
     * @param inimigo Não amigo.
     * @param logado Usuario logado.
     */
    public void recusarPedido(Usuario inimigo, Usuario logado) {
        logado.getPedidosAmizade().removeKey(inimigo.getLogin());        
    }
    
}
