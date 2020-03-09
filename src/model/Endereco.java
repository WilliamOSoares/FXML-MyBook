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
 * Classe que representa o endereço do usuario da rede social.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public class Endereco implements Serializable, Comparable{
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(String cidade, String estado, String pais) {
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
    /**
     * Pega a cidade definida pelo usuario.
     * @return Nome da cidade.
     */
    public String getCidade() {
        return cidade;
    }
    /**
     * Pega o Estado definida pelo usuario.
     * @return Nome do estado. 
     */
    public String getEstado() {
        return estado;
    }
    /**
     * Pega o país definida pelo usuario.
     * @return Nome do país.
     */
    public String getPais() {
        return pais;
    }
    
    @Override
    public String toString(){
        return cidade + "-" + estado + ", " + pais;        
    }

    @Override
    public int compareTo(Object o) {
        Endereco end = (Endereco) o;
        if(this.cidade.compareToIgnoreCase(end.getCidade())>0){
            return 1;
        }else if(this.cidade.compareToIgnoreCase(end.getCidade())<0){
            return -1;
        }else{
            return 0;
        }
    }
    
    
    
}
