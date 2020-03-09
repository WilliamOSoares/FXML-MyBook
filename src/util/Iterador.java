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
 * Interface que auxilia percorrer um determinado banco de dado.
 * 
 * @author William Oliveira e Samuel Ramos.
 */
public interface Iterador {
    
    /**
     * Verifica se existe o proximo objeto.
     * 
     * @return True se existe, false se não existe.
     */
    public boolean temProximo();
    
    /**
     * Move o cursor do iterador do atual para o proximo objeto, retornando o anterior.
     * 
     * @return Objeto anterior ao cursor.
     */
    public Object proximo();
    
}
