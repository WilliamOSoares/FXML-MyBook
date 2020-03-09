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

import java.io.Serializable;

/**
 * Classe que representa a postagem do usuario da rede social.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class Postagem implements Serializable, Comparable{
    private Object postagem;
    private String descricao;
    
    /**
     * Construtor padrão.
     */
    public Postagem(){}
    /**
     * Pega a postagem do usuario.
     * @return A postagem.
     */
    public Object getPostagem() {
        return postagem;
    }    
    /**
     * Altera o valor da postagem.
     * @param postagem Novo valor da postagem.
     */
    public void setPostagem(Object postagem) {
        this.postagem = postagem;
    }
    /**
     * Pega a descrição da postagem.
     * @return Descrição da postagem.
     */
    public String getDescricao() {
        return descricao;
    }
    /**
     * Altera a descrição da postagem.
     * @param descricao Novo valor da postagem.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public int compareTo(Object o) {
        Postagem p = (Postagem)o;
        if(this.descricao.compareToIgnoreCase(p.getDescricao())>0){
            return 1;
        }else if(this.descricao.compareToIgnoreCase(p.getDescricao())<0){
            return -1;
        }else{
            return 0;
        }
    }   
    
    @Override
    public String toString(){
        if(postagem!=null){
            return descricao + "\nCaminho do arquivo: " + (String) postagem;
        }else{
            return descricao;
        }
    }
    
}
