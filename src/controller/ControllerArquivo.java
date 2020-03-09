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
import java.util.LinkedList;
import model.Postagem;
import util.Arquivo;
import util.LinkedHashSet;
import util.TabelaHash;

/**
 * Classe que controla os arquivos.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class ControllerArquivo {
    
    private Arquivo arquivo = new Arquivo();
    private final String USERS = "users//";
    
    /**
     * Metodo responsavel por criar o diretorio para armazenar os usuarios
     */
    public void dirArmazenarUsuarios(){
        arquivo.criarDiretorio("users");
    }
    
    /**
     * Metodo responsavel por criar diretorio para outros arquivos que são gerados durante a execução
     */
    public void armazenarOutrosArquivos(){
        arquivo.criarDiretorio("etc");
    }
    
    /**
     * Metodo responsavel por criar um diretorio para cada usuario
     * @param nomeUsuario Nome do usuário.
     */
    public void criarDiretorioUsuario(String nomeUsuario){
        arquivo.criarDiretorio(USERS+ nomeUsuario);
        criarDiretorioPosts(nomeUsuario);
    }
    
    /**
     * Metodo responsavel por criar um diretorio para armazenar as postagens do usuario
     * @param nomeUsuario Nome do usuário. 
     */
    private void criarDiretorioPosts(String nomeUsuario){
        arquivo.criarDiretorio(USERS+ nomeUsuario+ "//" + "posts");
    }
    /**
     * Adiciona um arquivo post dentro do diretorio postagem do usuario
     * @param user Usuário que fez a postagem.
     * @param post Postagem.
     */
    public void adicionarPosts(String user, Postagem post){
        arquivo.salvarArquivo(post, USERS+user+"//posts",user+System.currentTimeMillis() , "post");
    }
    /**
     * Le todos os arquivos de postagem e adiciona no arrayList
     * @param nomeUsuario
     * @return
     * @throws ClassNotFoundException 
     */
    public LinkedList lerPosts(String nomeUsuario) throws ClassNotFoundException{
        LinkedList linkedlist = new LinkedList();
        File arq = new File(USERS+nomeUsuario+"//posts");
        if(arq.exists()){
            if(arq.isDirectory()){
                String listarDiretorio[] = arq.list();
                for(String d: listarDiretorio){
                    Object o = arquivo.lerArquivo(USERS+nomeUsuario+"//posts", d);
                    if(o instanceof Postagem){
                        linkedlist.add(o);
                    }
                }
            }
        }
        return linkedlist;
    }
    
    /**
     * Salvar a HashTable no disco rígido.
     * @param usuarios TabelaHash.
     */
    public void salvarHashTable(TabelaHash usuarios){
        arquivo.salvarArquivo(usuarios, "etc", "usuarios", "THash");
    }
    /**
     * Salvar a LinkedHashSet no disco rígido.
     * @param l LinkedHashSet.
     */
    public void salvarLinkedHS(LinkedHashSet l){
        arquivo.salvarArquivo(l, "etc", "users", "lkd");
    }
    /**
     * ler a HashTable já salva no disco rígido.
     * @return HashTable.
     */
    public TabelaHash lerHashTable(){
        TabelaHash usuarios = new TabelaHash();
        try {
            usuarios = (TabelaHash) arquivo.lerArquivo("etc", "usuarios.THash");                
        } catch (ClassNotFoundException ex) {
            //Quando o arquivo que era para ler retorna nulo
            return null;
        }
        return usuarios;
    }
    /**
     * ler a LinkedHashSet já salva no disco rígido.
     * @return LinkedHashSet.
     */
    public LinkedHashSet lerLinkedHS(){
        LinkedHashSet l = new LinkedHashSet();
        try{
            l = (LinkedHashSet) arquivo.lerArquivo("etc", "users.lkd");
        } catch (ClassNotFoundException ex) {
            //Quando o arquivo que era para ler retorna nulo
            return null;
        }
        return l;
    }
    
}
