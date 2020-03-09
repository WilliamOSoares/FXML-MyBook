// MyBook
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
 * Métodos que a HashSet tratando conflito com lista encadeada deve ter.
 * @author William Oliveira Soares  e Samuel Ramos.
 */
public interface IHashSet {
    /**
     * Coloca um dado na hashSet.
     * @param data Objeto a ser inserido.
     */
    public void put(Object data);
    /**
     * Verifica se um objeto já está na hashSet.
     * @param data Objeto verificado.
     * @return True se ele estiver na HashSet, se não False.
     */
    public boolean contains(Object data);
    /**
     * Remove um dado caso ele estiver na HashSet.
     * @param data Objeto a ser removido.
     */
    public void remove(Object data);
    /**
     * Verifica se a hashSet está sem nenhum dado.
     * @return True se estiver vazia, senão False.
     */
    public boolean isEmpty();
    /**
     * Retorna quantos dados há na hashSet.
     * @return Quantidade de dados.
     */
    public int size();
}
