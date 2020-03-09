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
 * Interface que auxilia no armazenamento de dados em um array que duplica 
 * automaticamente.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public interface IMyArray {
    /**
     * Adiciona um objeto comparable.
     * @param obj Objeto que tem que ser comparable.
     */
    public void add(Object obj);
    
    /**
     * pega o objeto que ja existe no Array.
     * @param obj Objeto a ser recuperado.
     * @return Objeto no array.
     */
    public Object get(Object obj);
    
    /**
     * Ver se o objeto já está na lista.
     * @param obj Objeto comparado.
     * @return Sim se tiver no array, não se não tiver.
     */
    public boolean contains(Object obj);
    
    /**
     * Numero de objetos no array;
     * @return Numero de objetos no array;
     */
    public int size();
    
    /**
     * Verifica se o array está vazio.
     * @return True se estiver e false se não.
     */
    public boolean isEmpty();
    
    /**
     * Auxilia percorrer o array.
     * @return O iterador.
     */
    public Iterador iterator();
    
}
