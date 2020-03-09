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
package util;

/**
 * Iterface do banco de dados que efetua a busca mais r�pida.
 * 
 * @author William Oliveira, Samuel Ramos.
 */
public interface IHashTable {
    /**
     * Adiciona um objeto na tabela hash e redimenciona o array caso o fator
     * de carga seja ultrapassado.
     * @param key Chave de pesquisa.
     * @param value Objeto guardado.
     */
    public void put(Object key, Object value);
    
    /**
     * Pega o objeto na tabela hash.
     * @param key Chave de pesquisa.
     * @return Objeto guardado na chave.
     */
    public Object get(Object key);
    
    /**
     * Remove a entrada da tabela hash a partir da chave.
     * @param key Chave de pesquisa.
     */
    public void removeKey(Object key);
    
    /**
     * Remove a entrada da tabela hash a partir do objeto.
     * @param value Objeto a ser removido.
     */
    public void removeValue(Object value);
    
    /**
     * Verifica se a hash est� vazia.
     * @return True se sim, False se n�o.
     */
    public boolean isEmpty();
    
    /**
     * Tamanho da tabela hash.
     * @return Tamanho do array da tabela hash.
     */
    public int size();
}
