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
package model;

import util.TabelaHash;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa o usuario da rede social.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class Usuario implements Serializable{
    private String login;
    private String senha;
    private String telefone;
    private String nomeCompleto;
    private String email;
    private String dataNascimento;
    private Endereco endereco;
    private String caminhoImgPerfil;
    private TabelaHash amigos;
    private TabelaHash pedidosAmizade;
    
    /**
     * Cria um usuario com todas as informações.
     * @param login User name.
     * @param senha Senha do usuario.
     * @param nomeCompleto Nome.
     * @param email Endereço eletrônico.
     * @param dataNascimento Data de nascimento.
     * @param endereco Nome da cidade, estado, pais.
     * @param telefone Numero de telefone.
     */
    public Usuario(String login, String senha, String nomeCompleto, String email, String dataNascimento, Endereco endereco, String telefone) {
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.amigos = new TabelaHash();
        this.pedidosAmizade = new TabelaHash();
        this.caminhoImgPerfil = "src\\view\\resources\\images\\default_avatar.png";
    }
    /**
     * Construtor de usuario vazio para a classe principal do programa.
     */
    public Usuario() { }      
    /**
     * Pega os amigos do usuario.
     * @return HashTable.
     */
    public TabelaHash getAmigos() {
        return amigos;
    }
    /**
     * Pega os pedidos de amizade.
     * @return HashTable.
     */
    public TabelaHash getPedidosAmizade() {
        return pedidosAmizade;
    }
    /**
     * Pega o User Name para o login.
     * @return Login cadastrado.
     */
    public String getLogin() {
        return login;
    }
    /**
     * Pega a senha cadastrada.
     * @return Senha cadastrada.
     */
    public String getSenha() {
        return senha;
    }
    /**
     * Pega o telefone cadastrado.
     * @return Telefone Cadastrado.
     */
    public String getTelefone() {
        return telefone;
    }
    /**
     * Pega o nome completo do usuario.
     * @return Nome cadastrado.
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    /**
     * Pega o e-mail cadastrado.
     * @return e-mail cadastrado.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Pega a data de nascimento cadastrada.
     * @return Data de nascimento.
     */
    public String getDataNascimento() {
        return dataNascimento;
    }
    /**
     * Pega o endereço cadastrado.
     * @return Endereço cadastrado.
     */
    public Endereco getEndereco() {
        return endereco;
    }
    
    public String getCaminhoImgPerfil() {
        return caminhoImgPerfil;
    }
    
    public void setCaminhoImgPerfil(String caminhoImgPerfil) {
        this.caminhoImgPerfil = caminhoImgPerfil;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }
}
