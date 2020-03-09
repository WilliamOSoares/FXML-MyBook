//MyBook//
/*******************************************************************************
Autores: Samuel Ramos dos Santos e William Oliveira Soares
Componente Curricular: MI Programa��o
Concluido em: 29/07/2018
Declaro que este c�digo foi elaborado por n�s de forma coletiva e n�o cont�m nenhum
trecho de c�digo de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e p�ginas ou documentos eletr�nicos da Internet. Qualquer trecho de c�digo
de outra autoria que n�o seja a nossa est� destacado com uma cita��o para o autor e a fonte
do c�digo, e estou ciente que estes trechos n�o ser�o considerados para fins de avalia��o.
***************************************************************************************/
package util;

import java.io.Serializable;

/**
 * Classe auxilia no armazenamento de dados.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public class Entrada implements Serializable{
    private Object key;
    private Object value;
    
    /**
     * Cria uma entrada para guardar uma chave de busca e o objeto.
     * @param key Chave de busca.
     * @param value Objeto a ser guardado.
     */
    public Entrada(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
    /**
     * Pega a chave de busca.
     * @return Chave de busca.
     */
    public Object getKey() {
        return key;
    }
    
    /**
     * Altera a chave de busca.
     * @param key chave de busca
     */
    public void setKey(Object key) {
        this.key = key;
    }
    /**
     * Pega o objeto guardado.
     * @return Objeto guardado.
     */
    public Object getValue() {
        return value;
    }
    /**
     * Altera o objeto guardado.
     * @param value Objeto guardado.
     */
    public void setValue(Object value) {
        this.value = value;
    }
    
    /**
     * Verifica se os objetos s�o iguais.
     * @param o Objeto a ser comparado.
     * @return True se s�o iguais, False se n�o.
     */
    @Override
    public boolean equals(Object o) {
        return (key == null && ((Entrada) o).key == null) ||
        (key!=null && key.equals(((Entrada)o).getKey()));
    }

}
