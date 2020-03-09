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
import model.Endereco;
import model.Usuario;
import util.LinkedHashSet;
/**
 * Classe que controla os usuários.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class ControllerUsuario {
    LinkedHashSet usuarios = new LinkedHashSet();
    
    /**
     * Construtor padrão.
     */
    public ControllerUsuario(){ }  
    /**
     * Construtor que recebe uma linkedHashSet.
     * @param usuarios LinkedHashSet que foi gravada no disco rígido.
     */
    public ControllerUsuario(LinkedHashSet usuarios){
        this.usuarios = usuarios;
    }
    /**
     * Pega a linkedHashSet.
     * @return LinkedHashSet.
     */
    public LinkedHashSet getUsuarios() {
        return usuarios;
    }
    /**
     * Altera a linkedHashSet
     * @param usuarios LinkedHashSet.
     */
    public void setUsuarios(LinkedHashSet usuarios) {
        this.usuarios = usuarios;
    }
    /**
     * Verifica se existe um usuário no sistema.
     * @param nome Username.
     * @return True se existir, senão false.
     */
    public boolean existeUser(String nome) {
        return usuarios.contains(nome);
    }
    /**
     * Cria um novo usuário se não existir.
     * @param login UserName do usuário.
     * @param senha Senha do usuário.
     * @param nome Nome completo do usuário.
     * @param email Endereço eletrônico do usuário.
     * @param dataNasci Data de nascimento do usuário.
     * @param cidade Cidade do usuário.
     * @param estado Estado do usuário.
     * @param pais País do usuário.
     * @param tell Telefone do usuário.
     * @return Usuário recém criado.
     * @throws CampoNaoPreenchidoException Caso um String esteja vazia.
     * @throws UsuarioExistenteException Caso o usuário já exista.
     */
    public Usuario confirmarCadastro(String login, String senha, String nome, String email, String dataNasci, String cidade, String estado, String pais, String tell) throws CampoNaoPreenchidoException, UsuarioExistenteException {
        if(login.isEmpty() || senha.isEmpty() || nome.isEmpty() || email.isEmpty() || dataNasci.isEmpty() || cidade.isEmpty() || estado.isEmpty() || pais.isEmpty() || tell.isEmpty())
            throw new CampoNaoPreenchidoException();
        Usuario u = new Usuario(login, senha, nome, email, dataNasci, new Endereco(cidade, estado, pais), tell);
        if(usuarios.contains(u.getLogin())){
            throw new UsuarioExistenteException();
        }
        usuarios.put(u.getLogin());
        return u;
    }
}
