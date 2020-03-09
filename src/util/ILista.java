//MyBook
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
 * Interface que auxilia no armazenamento de dados.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public interface ILista{    
    /**
     * Verifica se a lista está vazia.
     * 
     * @return True se estiver vazia, e falso se não estiver.
     */
    public boolean estaVazia();    
    /**
     * Calcula o tamanho da lista.
     * 
     * @return Tamanho da lista.
     */
    public int tamanho();    
    /**
     * Insere o objeto no inicio da lista.
     * 
     * @param o Objeto a ser inserido. 
     */
    public void insereInicio(Object o);
    /**
     * Insere o objeto no final da lista.
     * 
     * @param o Objeto a ser inserido. 
     */
    public void insereFinal(Object o);    
    /**
     * Remove o objeto no inicio da lista.
     * 
     * @return O objeto removido.
     */
    public Object removeInicio();
    
    /**
     * Remove o objeto no final da lista.
     * 
     * @return O objeto removido.
     */
    public Object removeUltimo();
    /**
     * Remove o objeto recebido por parâmetro.
     * @param o Objeto a ser removido.
     * @return True se achou e removeu o objeto, senão false.
     */
    public boolean remove(Object o);
    /**
     * Recupera o objeto no indice dado.
     * 
     * @param index Posição do objeto.
     * @return Objeto recuperado, caso o index seja menor do que zero e maior
     * do que o tamanho da lista, é retornado null.
     */
    public Object recupera(int index);
    /**
     * Verica se o objeto está na lista encadeada.
     * @param o Objeto verificado.
     * @return True se achou, senão False.
     */
    public boolean contem(Object o);
    /**
     * Cria um objeto que auxilia a percorrer a lista.
     * 
     * @return Iterador da lista.
     */
    public Iterador iterador();
}
